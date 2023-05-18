package com.valcon.videotechatodor.model;

import com.valcon.videotechatodor.utils.RoomType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoomType roomType;

    @Column(nullable = false)
    private int capacity;

    @OneToMany(mappedBy = "theater")
    private List<Projection> projections = new ArrayList<>();

    public Theater() {
    }

    public Theater(RoomType roomType, int capacity) {
        this.roomType = roomType;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Projection> getProjections() {
        return projections;
    }
}
