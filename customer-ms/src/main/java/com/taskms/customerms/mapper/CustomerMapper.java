package com.taskms.customerms.mapper;

import com.taskms.customerms.dto.CustomerRequest;
import com.taskms.customerms.dto.CustomerResponse;
import com.taskms.customerms.entity.CustomerEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity dtoToEntity(CustomerRequest customerRequest);

    CustomerResponse entityToDto(CustomerEntity customerEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDto(CustomerRequest customerRequest, @MappingTarget CustomerEntity entity);
}
