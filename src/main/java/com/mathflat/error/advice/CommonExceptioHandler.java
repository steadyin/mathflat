package com.mathflat.error.advice;

import com.mathflat.error.excpetion.BaseException;
import com.mathflat.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CommonExceptioHandler {

//    /**
//     * IllegalArgument
//     * 파라미터 오류
//     */
//    @ExceptionHandler
//    public ResponseEntity<ApiResponse> illegalExHandler(IllegalArgumentException e) {
//        ApiResponse apiResponse = ApiResponse.responseMessage(StatusCode.FAIL, e.getMessage());
//        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
//    }
//

//
//    /**
//     * NullPointer
//     * 널 포인트 오류
//     */
//    @ExceptionHandler
//    public ResponseEntity<ApiResponse> nullPointerHandler(NullPointerException e) {
//        ApiResponse apiResponse = ApiResponse.responseMessage(StatusCode.FAIL, e.getMessage());
//        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
//    }
//
//    /**
//     * MethodArgmentNotValid
//     * NotBlank
//     * 입력 파라미터 부재 오류
//     */
//    @ExceptionHandler
//    public ResponseEntity<ApiResponse> MethodArgumentNotValidHandler(MethodArgumentNotValidException e) {
//
//        Map<String, String> errors = new HashMap<>();
//        e.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError)error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//
//        ApiResponse apiResponse = ApiResponse.responseError(StatusCode.FAIL, errors);
//        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
//    }

    /**
     * Exception
     * 최상위 오류
     */
//    @ExceptionHandler
//    public ResponseEntity<Response> exHandler(Exception e) {
//        Response response = Response.createErrorResponse(BusinessExceptionMessage.BAD_REQUEST.getCode(), BusinessExceptionMessage.BAD_REQUEST.getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//    }

    /**
     * BaseException
     * 기본 오류
     */
//    @ExceptionHandler
//    public ResponseEntity<Response> exceptionHandler(BaseException e) {
//        Response response = Response.createErrorResponse(e.getBaseExceptionMessage().getCode(), e.getBaseExceptionMessage().getMessage());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//    }

    /**
     * DuplicateKey
     * 중복 오류
     */
    @ExceptionHandler
    public ResponseEntity<Response> runtimeException(Exception e) {
        if (e instanceof BaseException) {
            BaseException baseException = (BaseException) e;
            return new ResponseEntity(Response.createErrorResponse(baseException.getBaseExceptionMessage().getCode(), baseException.getBaseExceptionMessage().getCode()),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(Response.createErrorResponse("BASEIC", e.getLocalizedMessage())
                , HttpStatus.BAD_REQUEST);
    }

    //최상위
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public Result<Error> exHandler(Exception e) {
        log.error("[error ex] = {}]", e.getLocalizedMessage());
        return Result.createErrorResult(500, "내부 오류");
    }
}
