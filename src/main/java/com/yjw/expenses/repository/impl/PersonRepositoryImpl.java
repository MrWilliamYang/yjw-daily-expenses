package com.yjw.expenses.repository.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.yjw.expenses.pojo.entity.PersonEntity;
import com.yjw.expenses.pojo.vo.UpdatePersonInfoReqVO;
import com.yjw.expenses.repository.BaseRepository;
import com.yjw.expenses.repository.IPersonRepository;
import com.yjw.expenses.utils.MapperUtils;

/**
 * 人物数据访问实现层
 * 
 * @author YangJianWei
 * @version $Id: PersonRepositoryImpl.java, v 0.1 2018年10月9日 下午2:34:45 YangJianWei Exp $
 */
@Repository
public class PersonRepositoryImpl extends BaseRepository implements IPersonRepository {

    private RowMapper<PersonEntity> rowMapper = new BeanPropertyRowMapper<>(PersonEntity.class);

    private SimpleJdbcInsert        insertObject;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.insertObject = new SimpleJdbcInsert(dataSource);
        insertObject.withTableName("person").usingGeneratedKeyColumns("id");
    }

    /**
     * @see com.yjw.dailyexpenses.repository.IPersonRepository#save(com.yjw.dailyexpenses.pojo.entity.PersonEntity)
     */
    @Override
    public int savePerson(PersonEntity personEntity) {
        Map<String, Object> paramMap = MapperUtils.getDBProperties(personEntity);
        return insertObject.executeAndReturnKey(paramMap).intValue();
    }

    /**
     * @see com.yjw.expenses.repository.IPersonRepository#findPersonInfo(java.lang.Integer)
     */
    private static final String SQL_FIND_PERSON_INFO = "SELECT * FROM person WHERE id = ?";

    @Override
    public PersonEntity findPersonInfo(Integer id) {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_PERSON_INFO, new Object[] { id },
                rowMapper);//查询对象时容易抛空指针异常
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @see com.yjw.expenses.repository.IPersonRepository#deletePerson(java.lang.Integer)
     */
    private static final String SQL_DELETE_PERSON = "DELETE FROM person WHERE id = ?";

    @Override
    public int deletePerson(Integer id) {
        return jdbcTemplate.update(SQL_DELETE_PERSON, id);
    }

    /** 
     * @see com.yjw.expenses.repository.IPersonRepository#updatePersonInfo(com.yjw.expenses.pojo.vo.UpdatePersonInfoReqVO)
     */
    private static final String SQL_UPDATE_PERSONINFO = "UPDATE person SET gender = ?, age = ?, tel = ?, name = ?, password = ?, avatar = ? WHERE id = ?";

    @Override
    public int updatePersonInfo(UpdatePersonInfoReqVO request) {
        return jdbcTemplate.update(SQL_UPDATE_PERSONINFO, request.getGender(), request.getAge(),
            request.getTel(), request.getName(), request.getPassword(), request.getAvatar(),
            request.getId());
    }

    /**
     * @see com.yjw.expenses.repository.IPersonRepository#findAllPersonList()
     */
    private static final String SQL_FINDALL_PERSONLIST = "SELECT * FROM person";
    
    @Override
    public List<PersonEntity> findAllPersonList() {
        return jdbcTemplate.query(SQL_FINDALL_PERSONLIST, rowMapper);
    }

}
