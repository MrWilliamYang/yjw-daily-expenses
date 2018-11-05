/**
 * hxgy Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.yjw.expenses.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * 数据访问层的基类
 *
 * @author WindsYan
 * @version $Id: com.hxgy.healthcard.cardcenter.repository, v 0.1 2017/11/10 14:52 WindsYan Exp $
 */
public abstract class BaseRepository {

    protected final Logger               logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected JdbcTemplate               jdbcTemplate;

    //带参数名的jdbcTemplate
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
}
