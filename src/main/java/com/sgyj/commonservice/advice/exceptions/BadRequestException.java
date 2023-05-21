package com.sgyj.commonservice.advice.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException () {super();}

    public BadRequestException ( String msg ) {super( msg );}

}
