package com.github.ganlong.commons.core.custom.validator.common;

import javax.validation.groups.Default;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/12 14:16
 * @PackageName:com.github.ganlong.commons.core.custom.validator.common
 * @ClassName: UpdateGroup
 * @Version 1.0
 * @Description: 同一个对象要复用，比如 userId在更新时需要校验 userId ，而在新增时则不需要参数 userId。
 * 在需要校验的地方@Validated 声明校验组 `update(@Validated(UpdateGroup.class) User user)`
 * 在DTO的字段上定义好groups = {分组类型}  `@NotNull(message="id 不能为空",groups= Update.class)
 * 【注】 注意: 在声明分组的时候尽量加上 extends javax.validation.groups.Default
 * 否则，你在声明组的时候就会出现你添加的组不生效。
 */
public interface UpdateGroup extends Default {
}
