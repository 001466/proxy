package com.ec.proxy.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ec.proxy.model.Proxies;
import com.ec.proxy.model.ProxiesExample;

public interface ProxiesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proxies
     *
     * @mbg.generated
     */
    long countByExample(ProxiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proxies
     *
     * @mbg.generated
     */
    int deleteByExample(ProxiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proxies
     *
     * @mbg.generated
     */
    int insert(Proxies record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proxies
     *
     * @mbg.generated
     */
    int insertSelective(Proxies record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proxies
     *
     * @mbg.generated
     */
    List<Proxies> selectByExample(ProxiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proxies
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Proxies record, @Param("example") ProxiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table proxies
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Proxies record, @Param("example") ProxiesExample example);
    
    int createTable();
    int insertByList(Collection<Proxies> records);
}