package com.yjw.interview.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjw.interview.common.ResponseErrorEnum;
import com.yjw.interview.pojo.entity.PersonEntity;
import com.yjw.interview.pojo.vo.BaseResponse;
import com.yjw.interview.pojo.vo.FindPersonInfoReqVO;
import com.yjw.interview.pojo.vo.PersonRegisterReqVO;
import com.yjw.interview.repository.IPersonRepository;
import com.yjw.interview.service.IPersonService;

/**
 * 人物服务实现类
 * 
 * @author YangJianWei
 * @version $Id: PersonServiceImpl.java, v 0.1 2018年10月9日 下午2:27:17 YangJianWei Exp $
 */
@Service
public class PersonServiceImpl implements IPersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private IPersonRepository   personRepository;

    /**
     * @see com.yjw.interview.service.IPersonService#personRegister(com.yjw.interview.pojo.vo.PersonRegisterReqVO)
     */
    @Override
    public BaseResponse personRegister(PersonRegisterReqVO request) {
        PersonEntity personEntitys = new PersonEntity();
        PersonEntity personEntity = coverPersonEntity(request, personEntitys);
        int num = personRepository.savePerson(personEntity);
        if (num < 1 || num == 0) {
            return BaseResponse.error(ResponseErrorEnum.DATE_ADD_WRONG);
        }
        return BaseResponse.success();
    }

    private PersonEntity coverPersonEntity(PersonRegisterReqVO request,
                                           PersonEntity personEntitys) {
        Date date = new Date();
        personEntitys.setAge(request.getAge());
        personEntitys.setAvatar(request.getAvatar());
        personEntitys.setCreateTime(date);
        personEntitys.setGender(request.getGender());
        personEntitys.setName(request.getName());
        personEntitys.setPassword(request.getPassword());
        personEntitys.setTel(request.getTel());
        personEntitys.setUpdateTime(date);
        return personEntitys;
    }

    /**
     * @see com.yjw.interview.service.IPersonService#findPersons(com.yjw.interview.pojo.vo.FindPersonInfoReqVO)
     */
    @Override
    public BaseResponse findPersonInfo(FindPersonInfoReqVO request) {
        int id = request.getId();
        PersonEntity personEntity = personRepository.findPersonInfo(id);
        if (personEntity == null) {
            logger.warn("未查询到指定用户的相关信息,Id={}", request.getId());
            return BaseResponse.error(ResponseErrorEnum.DATA_NOT_EXIST);
        }
        logger.info("查询成功");
        return BaseResponse.success(personEntity);
    }
}
