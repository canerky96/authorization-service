package com.kaya.auth.authserver.specification;

import com.kaya.auth.authserver.dto.PermissionQueryDTO;
import com.kaya.auth.authserver.entity.Permission;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PermissionSpecification implements Specification<Permission> {

  private PermissionQueryDTO permissionQueryDTO;

  @Override
  public Predicate toPredicate(
      Root<Permission> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(permissionQueryDTO.getCode())) {
      predicates.add(criteriaBuilder.equal(root.get("code"), permissionQueryDTO.getCode()));
    }

    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
  }
}
