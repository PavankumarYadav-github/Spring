package springrest.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springrest.pojo.StudentPOJO;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
	
	private String message;
	private StudentPOJO data;
	private List<StudentPOJO> list;

}
