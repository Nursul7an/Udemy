package modul2.edu.udemy.model.enums;

import modul2.edu.udemy.model.dto.request.RegisterRequest;

public enum UserStatus {
    USER_ROLE{
        @Override
        public void castByType(RegisterRequest registerRequest) throws IllegalArgumentException {
            registerRequest.setAudience(null);
            registerRequest.setExperience(null);
        }
    },
    USER_MENTOR{
        @Override
        public void castByType(RegisterRequest registerRequest) throws IllegalArgumentException {
            var experience = registerRequest.getExperience();
            var audience = registerRequest.getAudience();
            if (experience == null || audience == null)
                throw new IllegalArgumentException("Experience and audience are required!");
        }
    },
    USER_ADMIN{
        @Override
        public void castByType(RegisterRequest registerRequest) throws IllegalArgumentException {

        }
    };
    public abstract void castByType(RegisterRequest registerRequest) throws IllegalArgumentException;
}
