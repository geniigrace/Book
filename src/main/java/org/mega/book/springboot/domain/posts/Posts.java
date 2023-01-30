package org.mega.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mega.book.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /*
    * @Builder를 통해 제공되는 빌드 클래스를 사용
    * 생성자나 빌더 생성 역할은 똑같음
    * Builder pattern 은 Setter 가 없는 상황에서 잘 쓰임
    * -> 디자인 패턴
    * 클래스 안에 객체를 만드는 내부 클래스가 이미 존재함 보안성 향상을 위해 쓰임
    * 컨트롤러 등 에서 객체를 만들면 하나 가지고 돌려씀
    *  -> single tone
    * 객체를 생성하는 클래스와 표현하는 클래스를 분리하여 구분하여 제공
    *
    * New Example(b,a) -> 실행 전까지는 문제를 찾을 수 없음
    * 생성자
    * public Example(String a, String b){
    *   this.a = a;
    *   this.b = b;
    * }
    *
    * 빌더가 있으면 오류가 날 수 없음
    * Example.builder()
    *       .a(a)
    *       .b(b)
    *       .build();
    * */


    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
