package com.github.ganlong.commons.api.enums;

/**
 * @Author KnockingFarmers
 * @Date 2022/12/14 9:25
 * @PackageName:com.github.ganlong.commons.api.enums
 * @ClassName: MessageEnum
 * @Description: TODO
 * @Version 1.0
 */
public enum ApiMessageEnum {


    /**
     * 查询成功
     */
    SELECT_OK("查询成功"),

    /**
     * 修改成功
     */
    UPDATE_OK("修改成功"),

    /**
     * 删除成功
     */
    DELETE_OK("删除成功"),

    /**
     * 插入成功
     */
    INSERT_OK("插入成功"),

    /**
     * 查询失败
     */
    SELECT_ERROR("查询失败"),

    /**
     * 修改失败
     */
    UPDATE_ERROR("修改失败"),

    /**
     * 删除失败
     */
    DELETE_ERROR("删除失败"),

    /**
     * 插入失败
     */
    INSERT_ERROR("插入失败");

    private String message;
    ApiMessageEnum(String message) {
        this.message = message;
    }

}
