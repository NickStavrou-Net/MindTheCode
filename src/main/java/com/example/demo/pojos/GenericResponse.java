package com.example.demo.pojos;

import com.example.demo.helpers.ApiErrorMessage;

public class GenericResponse<T>
{
    private T data;
    private ApiErrorMessage errorMessage;

    public GenericResponse(ApiErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public GenericResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ApiErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
}
