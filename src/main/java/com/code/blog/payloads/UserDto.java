package com.code.blog.payloads;







import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min = 2,message="user name must be min of 2 character")
	private String name;
	
	@Email(message = "Invaid Email")
	private String email;
	
	@NotEmpty
	@Size(min=5,max=10,message="password must be more than 3 characters and less than 10 characters")
	@Pattern(regexp = "/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^\\w\\s]).{8,}$/")
	private String password;
	
	@NotEmpty
	private String about;
	
}
