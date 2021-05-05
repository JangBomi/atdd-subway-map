package wooteco.subway.line;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LineDao implements LineRepository {
    private Long seq = 0L;
    private final List<Line> lines = new ArrayList<>();

    @Override
    public Line save(Line line) {
        Line persistLine = createNewObject(line);
        this.lines.add(persistLine);
        return persistLine;
    }

    private Line createNewObject(Line line) {
        Field field = ReflectionUtils.findField(Line.class, "id");
        field.setAccessible(true);
        ReflectionUtils.setField(field, line, ++seq);
        return line;
    }

    @Override
    public List<Line> findAll() {
        return lines;
    }

    @Override
    public Line findById(Long id) {
        return lines.stream()
                .filter(line -> line.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 id에 맞는 노선을 찾을 수 없습니다."));
    }

    @Override
    public Line update(Long id, Line newLine) {
        remove(id);
        Field field = ReflectionUtils.findField(Line.class, "id");
        field.setAccessible(true);
        ReflectionUtils.setField(field, newLine, id);
        lines.add(newLine);
        return newLine;
    }

    @Override
    public void remove(Long id) {
        if (!lines.removeIf(line -> line.getId().equals(id))) {
            throw new IllegalArgumentException("해당 id에 맞는 노선을 찾을 수 없습니다.");
        }
    }
}
