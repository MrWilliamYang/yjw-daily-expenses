package com.yjw.interview.repository.impl;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.yjw.interview.pojo.entity.PersonEntity;
import com.yjw.interview.pojo.vo.UpdatePersonInfoReqVO;
import com.yjw.interview.repository.BaseRepository;
import com.yjw.interview.repository.IPersonRepository;
import com.yjw.interview.utils.MapperUtils;

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
     * @see com.yjw.interview.repository.IPersonRepository#findPersonInfo(java.lang.Integer)
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
     * @see com.yjw.interview.repository.IPersonRepository#deletePerson(java.lang.Integer)
     */
    private static final String SQL_DELETE_PERSON = "DELETE FROM person WHERE id = ?";

    @Override
    public int deletePerson(Integer id) {
        return jdbcTemplate.update(SQL_DELETE_PERSON, id);
    }

    /** 
     * @see com.yjw.interview.repository.IPersonRepository#updatePersonInfo(com.yjw.interview.pojo.vo.UpdatePersonInfoReqVO)
     */
    private static final String SQL_UPDATE_PERSONINFO = "UPDATE person SET gender = ?, age = ?, tel = ?, name = ?, password = ?, avatar = ? WHERE id = ?";

    @Override
    public int updatePersonInfo(UpdatePersonInfoReqVO request) {
        return jdbcTemplate.update(SQL_UPDATE_PERSONINFO, request.getGender(), request.getAge(),
            request.getTel(), request.getName(), request.getPassword(), request.getAvatar(),
            request.getId());
    }

}
