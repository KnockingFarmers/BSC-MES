package com.github.ganlong.vo.production;

import com.github.ganlong.model.production.Equipment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author KnockingFarmers
 * @Date 2022/12/28 10:12
 * @PackageName:com.github.ganlong.model.dto.production
 * @ClassName: EquipmentVo
 * @Description: TODO
 * @Version 1.0
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class EquipmentVo extends Equipment {

    private String lineIdStr;

    private String supplierIdStr;

    public String getLineIdStr(){
        return super.getLineId().toString();
    }

    public String getSupplierIdStr(){
        return super.getSupplierId().toString();
    }
}
