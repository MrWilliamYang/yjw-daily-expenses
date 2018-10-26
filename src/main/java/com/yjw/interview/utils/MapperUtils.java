package com.yjw.interview.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.Column;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * 获取实体对象映射的
 *
 * @author 
 * @version $Id: MapperUtils.java, v 0.1 2017年12月20日 上午10:31:14  $
 */
@Component
public class MapperUtils {

    /**
     * 类的列名映射缓存
     */
    private static final Map<Type, Map<String, String>> ENTITY_MAP = new ConcurrentHashMap<>();
    /**
     * 类的表名映射缓存
     */
    private static final Map<Class<?>, String>          TABLE_MAP  = new ConcurrentHashMap<>();

    /**
     * 获取指定对象的列映射集,key为属性名，value为@column名
     *
     * @param clazz
     * @return
     */
    public static Map<String, String> getColumnMap(Class<?> clazz) {

        if (ENTITY_MAP.containsKey(clazz)) {
            return ENTITY_MAP.get(clazz);
        }
        System.err.println("遍历类属性！");
        Field[] fields = clazz.getDeclaredFields();
        Map<String, String> columnMap = new HashMap<>();
        boolean flag = true;
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                String columnName = column.name();
                columnName = columnName.trim();
                if (!"".equals(columnName)) {
                    flag = false;
                    columnMap.put(field.getName(), columnName);
                }

            }
        }
        if (flag) {
            return null;
        }
        ENTITY_MAP.put(clazz, columnMap);
        return columnMap;
    }

    /**
     * 获取实体表名
     *
     */
    public static String getTableName(Class<?> clazz) {
        String tableName = TABLE_MAP.get(clazz);
        if (tableName != null) {
            return tableName;
        }
        System.err.println("获取实体表名！");
        Table table = clazz.getAnnotation(Table.class);
        if (table != null) {
            tableName = table.name();
            tableName = tableName.trim();
            if (tableName != null && tableName.length() != 0) {
                TABLE_MAP.put(clazz, tableName);
            }
        }
        return tableName;
    }

    /**
     * 获取对象的属性名与属性值对应map，其key为bean的@column值
     *
     * @param obj
     * @return
     */
    public static Map<String, Object> getDBProperties(Object obj) {
        Map<String, String> columnMap = getColumnMap(obj.getClass());
        return getDBProperties(obj, columnMap);
    }

    /**
     * 根据属性名与数据库列名的对应map(columnMap),获取一个bean（obj）的列名-值map
     *
     * @param obj
     * @param columnMap
     * @return
     */
    public static Map<String, Object> getDBProperties(Object obj, Map<String, String> columnMap) {
        Map<String, Object> properties = getBeanProperties(obj);
        Map<String, Object> mappedProps = new HashMap<>(properties.size());
        if (columnMap != null) {
            properties.forEach((k, v) -> {
                String columnName = columnMap.get(k);
                if (columnName != null) {
                    mappedProps.put(columnName, v);
                } else {
                    mappedProps.put(k, v);
                }
            });
        }
        if (mappedProps.isEmpty()) {
            return properties;
        }
        return mappedProps;
    }

    /**
     * 获取bean对象的属性map，key为属性名，value为属性值
     *
     * @param bean
     * @return
     */
    public static Map<String, Object> getBeanProperties(Object bean) {
        if (bean == null) {
            throw new RuntimeException("参数不能为null");
        }
        Map<String, Object> properties = new HashMap<>();
        PropertyDescriptor[] propertyDescriptors = BeanUtils
            .getPropertyDescriptors(bean.getClass());
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String name = propertyDescriptor.getName();
            if ("class".equals(name)) {
                continue;
            }
            Method readMethod = propertyDescriptor.getReadMethod();
            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                readMethod.setAccessible(true);
            }
            Object value = null;
            try {
                value = readMethod.invoke(bean);
            } catch (IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException e) {
                throw new FatalBeanException("无法读取属性：" + name, e);
            }
            properties.put(name, value);
        }
        return properties;
    }

    public static <T> Map<String, Object>[] getProrpMaps(List<T> datas) {
        @SuppressWarnings("unchecked")
        Map<String, Object>[] maps = new HashMap[datas.size()];
        Map<String, String> columnMap = getColumnMap(datas.get(0).getClass());
        for (int i = 0; i < datas.size(); i++) {
            Map<String, Object> dbProperties = getDBProperties(datas.get(i), columnMap);
            maps[i] = dbProperties;
        }
        return maps;
    }

    public static <T> RowMapper<T> name(Class<T> clazz) {
        new BeanPropertyRowMapper<>();
        return null;
    }

}
