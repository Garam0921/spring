package dw.majorflow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "free_board")
public class FreeBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long freeBoardId;

    @Column
    private String title;

    @Column
    private String text;

    @Column
    private LocalDateTime FreeBoardTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
