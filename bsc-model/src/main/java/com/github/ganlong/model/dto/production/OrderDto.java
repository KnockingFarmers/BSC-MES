package com.github.ganlong.model.dto.production;

import com.github.ganlong.model.production.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author KnockingFarmers
 * @Date 2022/12/20 9:49
 * @PackageName:com.github.ganlong.model.dto.production
 * @ClassName: OrderDto
 * @Description: TODO
 * @Version 1.0
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto extends Order {

    private String orderProductIdStr;

    private String customerIdStr;


    public String getOrderProductIdStr(){
        return super.getOrderProductId().toString();
    }

    public String getCustomerIdStr(){
        return super.getCustomerId().toString();
    }
}
