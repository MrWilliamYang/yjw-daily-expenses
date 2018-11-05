package com.yjw.expenses.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjw.expenses.common.ResponseErrorEnum;
import com.yjw.expenses.pojo.entity.PersonEntity;
import com.yjw.expenses.pojo.vo.BaseResponse;
import com.yjw.expenses.pojo.vo.DeletePersonReqVO;
import com.yjw.expenses.pojo.vo.FindPersonInfoReqVO;
import com.yjw.expenses.pojo.vo.PersonRegisterReqVO;
import com.yjw.expenses.pojo.vo.UpdatePersonInfoReqVO;
import com.yjw.expenses.repository.IPersonRepository;
import com.yjw.expenses.service.IPersonService;

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
     * @see com.yjw.expenses.service.IPersonService#personRegister(com.yjw.expenses.pojo.vo.PersonRegisterReqVO)
     */
    @Override
    public BaseResponse personRegister(PersonRegisterReqVO request) {
        PersonEntity personEntitys = new PersonEntity();
        PersonEntity personEntity = coverPersonEntity(request, personEntitys);
        int num = personRepository.savePerson(personEntity);
        if (num < 1 || num == 0) {
            logger.warn("注册失败,请重新注册,Name={}", request.getName());
            return BaseResponse.error(ResponseErrorEnum.DATE_ADD_WRONG);
        }
        logger.info("注册成功");
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
     * @see com.yjw.expenses.service.IPersonService#findPersons(com.yjw.expenses.pojo.vo.FindPersonInfoReqVO)
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

    /**
     * @see com.yjw.expenses.service.IPersonService#updatePersonInfo(com.yjw.expenses.pojo.vo.UpdatePersonInfoReqVO)
     */
    @Override
    public BaseResponse updatePersonInfo(UpdatePersonInfoReqVO request) {
        PersonEntity entity = new PersonEntity();
        BeanUtils.copyProperties(request, entity);
        int num = personRepository.updatePersonInfo(request);
        if (num < 1 || num > 1) {
            logger.warn("修改失败,数据修改错误,Id={}", request.getId());
            return BaseResponse.error(ResponseErrorEnum.DATE_UPDATE_WRONG);
        }
        logger.info("数据修改成功, 修改{}条记录！", num);
        return BaseResponse.success();
    }

    /**
     * @see com.yjw.expenses.service.IPersonService#deletePerson(com.yjw.expenses.pojo.vo.DeletePersonReqVO)
     */
    @Override
    public BaseResponse deletePerson(DeletePersonReqVO request) {
        int id = request.getId();
        int num = personRepository.deletePerson(id);
        if (num < 1 || num > 1) {
            logger.warn("删除失败,数据删除错误,Id={}", request.getId());
            return BaseResponse.error(ResponseErrorEnum.DATE_DELETE_WRONG);
        }
        logger.info("数据删除成功, 删除{}条记录！", num);
        return BaseResponse.success();
    }

    /**
     * @see com.yjw.expenses.service.IPersonService#findAllPersonList()
     */
    @Override
    public BaseResponse findAllPersonList() {
        List<PersonEntity> entitys = personRepository.findAllPersonList();
        if (entitys.isEmpty() || entitys == null) {
            logger.warn("数据不存在");
            return BaseResponse.error(ResponseErrorEnum.DATA_NOT_EXIST);
        }
        logger.info("查询成功");
        return BaseResponse.success(entitys);
    }
}
