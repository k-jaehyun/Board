package com.sparta.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
//JPA Entity 클래스들이 해당 추상 클래스를 상속할 경우 createdAt, modifiedAt 처럼 추상 클래스에 선언한 멤버변수를 컬럼으로 인식할 수 있게 해줌. -> 즉, 이걸 상속받으면 자연스럽게 변수를 컬럼을 가진다. -> abstract를 안써도 되긴 하는데 이 자체를 entity로 쓸 일은 없을 것이기 때문에 추상클래스를 걸어주는게 더 좋다.
@EntityListeners(AuditingEntityListener.class)   //이걸 달아줘야 자동으로 시간 넣어주는 기능이 수행됨. (Auditing 기능을 넣어주는 것임)
public abstract class Timestamped {

    @CreatedDate
    @Column(updatable = false)    // 최초 생성 시간은 바뀌면 안됨 -> @컬럼에 (updatable = false) 을 쓰면 업데이트가 되는 것을 막는다.
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate   // 변경 할 때 해당 변경시간마다 저장됨.
    @Column
    @Temporal(TemporalType.TIMESTAMP)   //자바의 날짜 타입(java.util.Date, java.util.Calendar)을 매핑할 때 사용.
    private LocalDateTime modifiedAt;
}
