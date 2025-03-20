package Monitora_Habitos.Entities;

import java.time.LocalDate;
import java.util.UUID;

import Monitora_Habitos.Enums.StatusHabit;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_habitRegister")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class HabitRegister {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "habit_id")
    private Habit habit;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private StatusHabit statusHabit;

    public HabitRegister(UUID id, Habit habit, LocalDate date, StatusHabit statusHabit) {
        this.id = id;
        this.habit = habit;
        this.date = date.now();
        this.statusHabit = statusHabit;
    }

    
}
