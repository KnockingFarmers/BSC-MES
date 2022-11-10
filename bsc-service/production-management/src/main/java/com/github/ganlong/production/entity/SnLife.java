package com.github.ganlong.production.entity;

import com.github.ganlong.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ganlong
 * @since 2022-11-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("production_sn_life")
public class SnLife extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 工站，0未通过，1通过
     */
    private Integer op010;

    private Integer op020;

    private Integer op030;

    private Integer op050;

    private Integer op070;

    private Integer op090;

    private Integer op110;

    private Integer op160;

    private Integer op180;

    private Integer op185;

    private Integer op190;

    private Integer op250;

    private Integer op260;

    private Integer op265;

    private Integer op270;

    private Integer op275;

    private Integer op280;

    private String op290;

    private Long productId;

    /**
     * 插入时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModify;


}
