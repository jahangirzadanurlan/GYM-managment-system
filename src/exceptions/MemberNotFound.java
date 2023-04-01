package exceptions;

import enums.ExceptionEnum;

public class MemberNotFound extends RuntimeException{
    public MemberNotFound() {
        super(ExceptionEnum.NotFoundMember.name());
    }
}
