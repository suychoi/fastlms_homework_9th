package com.example.zerobase;

import com.example.zerobase.domain.ZerobaseCourse;
import com.example.zerobase.domain.ZerobaseCourseRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class Homework {
    private final ZerobaseCourseRepository repository;

    // TODO: 테스트가 통과할 수 있도록 아래 메서드 들을 작성하세요.

    public Optional<ZerobaseCourse> getZerobaseCourse(Long id) {
        // TODO: id 가 일치하며, hidden = false 인 강의만 조회되어야 함

        ZerobaseCourse zerobaseCourse = repository.findById(id);

        if (zerobaseCourse == null || zerobaseCourse.isHidden()){
            return Optional.empty();
        }

        return Optional.of(zerobaseCourse);
    }

    public List<ZerobaseCourse> getZerobaseCourse(String status) {
        // TODO: status가 일치하고, hidden = false 인 강의들이 조회되어야 함

        List<ZerobaseCourse> listTest = repository.findAll();
        List<ZerobaseCourse> list = null;

        for (int i = 0; i < listTest.size(); i++){
            if(listTest.get(i).getStatus() == status && !listTest.get(i).isHidden()){
                System.out.println("리스트 값 : " + listTest.get(i).getStatus());
                System.out.println("입력값 : " + status);
                System.out.println(listTest.get(i));
//                list.addAll(list.size(), listTest.get(i));
                list.add(0, listTest.get(i));
            }
        }

        return list;
    }

    public List<ZerobaseCourse> getOpenZerobaseCourse(LocalDate targetDt) {
        // TODO: status = "OPEN" 이고, hidden = false 이며,
        //  startAt <= targetDt && targetDt <= endAt 인 강의만 조회되어야함.
        return null;
    }
}
