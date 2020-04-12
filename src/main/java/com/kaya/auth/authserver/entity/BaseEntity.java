package com.kaya.auth.authserver.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.OffsetDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private String id;

  private OffsetDateTime createDate;
  private OffsetDateTime updateDate;

  @PrePersist
  void onCreate() {
    this.createDate = OffsetDateTime.now();
  }

  @PreUpdate
  void onUpdate() {
    this.updateDate = OffsetDateTime.now();
  }
}
