package by.pisetskiy.iquiz.service;

import static by.pisetskiy.iquiz.util.QuizUtil.map;
import static by.pisetskiy.iquiz.util.QuizUtil.mapper;

import by.pisetskiy.iquiz.api.request.PositionRequest;
import by.pisetskiy.iquiz.model.entity.JobPosition;
import by.pisetskiy.iquiz.model.entity.Quiz;
import by.pisetskiy.iquiz.model.repository.JobPositionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PositionService implements BaseService<JobPosition, PositionRequest> {

    private final JobPositionRepository repository;

    @Override
    public List<JobPosition> findAll() {
        return repository.findAll();
    }

    @Override
    public JobPosition findById(Long id) {
        var position = repository.getById(id);
        position.getQuizzes();
        return position;
    }

    @Override
    public JobPosition create(PositionRequest request) {
        var position = JobPosition.builder()
                .title(request.getTitle())
                .quizzes(map(request.getQuizzes(), mapper(Quiz::new)))
                .build();
        return repository.save(position);
    }

    @Override
    public JobPosition update(Long id, PositionRequest request) {
        var position = repository.getById(id);
        position.setTitle(request.getTitle());
        position.setQuizzes(map(request.getQuizzes(), mapper(Quiz::new)));
        return repository.save(position);
    }
}