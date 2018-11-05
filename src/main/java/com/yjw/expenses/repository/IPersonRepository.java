package com.yjw.expenses.repository;

import java.util.List;

import com.yjw.expenses.pojo.entity.PersonEntity;
import com.yjw.expenses.pojo.vo.UpdatePersonInfoReqVO;

/**
 * 人物数据访问层
 * 
 * @author YangJianWei
 * @version $Id: IPersonRepository.java, v 0.1 2018年10月9日 下午2:29:07 YangJianWei Exp $
 */
public interface IPersonRepository {

    int savePerson(PersonEntity personEntity);

    PersonEntity findPersonInfo(Integer id); 
    
    int deletePerson(Integer id);
    
    int updatePersonInfo(UpdatePersonInfoReqVO request);
    
    List<PersonEntity> findAllPersonList();
}
