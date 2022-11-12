package com.github.ganlong.model.material;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.ganlong.model.base.BaseEntity;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganlong
 * @since 2022-11-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("material_supplier")
public class Supplier extends BaseEntity {

    @Serialization
    private static final long serialVersionUID=1L;

    /**
     * 供应商别名
     */
    private String supplierName;

    /**
     * 供应商的物料编号
     */
    private String supplierMaterialNo;

    /**
     * 供应商电话
     */
    private String supplierPhone;

    /**
     * 供应商联系人昵称
     */
    private String supplierContactPerson;

    /**
     * 供应商微信
     */
    private String supplierWechat;

    /**
     * 供应商所属公司
     */
    private String supplierCompany;


}
