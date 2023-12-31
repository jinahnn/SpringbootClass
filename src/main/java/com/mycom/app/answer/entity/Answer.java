package com.mycom.app.answer.entity;


import com.mycom.app.question.entity.Question;
import com.mycom.app.user.entity.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

//Question에 대한 대답(table용)을 관련한 entity

@Getter
@Setter
@Entity
public class Answer {

    //필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//id(대답pk)
    @Column
    private String content;//content
    @Column
    private LocalDateTime createDate;//create_date 답변등록일
    @Column
    private LocalDateTime modifyDate;//modify_date 답변수정일

    @ManyToOne
    private Question question; //Question 테이블 과 연관이 있는 테이블 이라는 것을 명시

    //한 명의 USER가 여러 개의 답변을 작성할 수 있다
    @ManyToOne
    private SiteUser writer; //user정보(id,username,email,password)

    //1개의 답변은 추천인이 많을 수 있다
    //1명은 추천인은 여러 답변들을 추천할 수 있다
    //추천인이 중복되지않게 하기위해 Set타입으로 지정
    @ManyToMany
    Set<SiteUser> voter;
}

