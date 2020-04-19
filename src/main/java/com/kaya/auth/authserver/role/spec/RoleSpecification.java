package com.kaya.auth.authserver.role.spec;

import com.kaya.auth.authserver.role.dto.RoleQueryDTO;
import com.kaya.auth.authserver.role.entity.Role;
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
public class RoleSpecification implements Specification<Role> {

  private RoleQueryDTO roleQueryDTO;

  @Override
  public Predicate toPredicate(
      Root<Role> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(roleQueryDTO.getCode())) {
      predicates.add(criteriaBuilder.equal(root.get("code"), roleQueryDTO.getCode()));
    }

    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
  }
}
