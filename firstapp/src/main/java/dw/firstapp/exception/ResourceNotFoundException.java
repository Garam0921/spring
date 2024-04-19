package dw.firstapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // http 의 상태 - 예외에도 응답해주는 기능
public class ResourceNotFoundException extends RuntimeException {
    // serialVersionUID = 선택사항. 에러가 가지고 있는 고유 아이디.
    private static final long serialVersionUID = 1L;
    //아래의 것들은 선택사항이지만, 에러만 띄우는 것이 아니라 왜 에러가 나는지 알려주는 기능을 구현
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    // constructor 들어가서 첫번째로 뜨는 거 클릭, 전체 선택
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : %s",
                resourceName, fieldName, fieldValue)); // C 스타일 옛날 스트링 코드
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
