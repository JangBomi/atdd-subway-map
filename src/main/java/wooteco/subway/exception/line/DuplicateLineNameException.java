package wooteco.subway.exception.line;

import org.springframework.http.HttpStatus;
import wooteco.subway.exception.SubwayException;

public class DuplicateLineNameException extends SubwayException {
    private static final String MESSAGE = "같은 이름의 노선은 등록할 수 없습니다.";

    public DuplicateLineNameException() {
        super(MESSAGE, HttpStatus.BAD_REQUEST);
    }
}
