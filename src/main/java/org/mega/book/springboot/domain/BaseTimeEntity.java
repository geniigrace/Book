package org.mega.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
/*BaseTime Entity 클래를 상속 받으면 CreatedDate, LastModifiedDate 를 컬럼으로 인식하록 합니다.*/
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
