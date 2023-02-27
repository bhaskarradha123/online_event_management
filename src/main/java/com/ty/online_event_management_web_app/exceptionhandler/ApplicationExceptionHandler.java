package com.ty.online_event_management_web_app.exceptionhandler;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.online_event_management_web_app.exception.IdNotFoundByBandException;
import com.ty.online_event_management_web_app.exception.IdNotFoundByCostumeException;
import com.ty.online_event_management_web_app.exception.IdNotFoundByDecorationException;
import com.ty.online_event_management_web_app.exception.IdNotFoundByMakeUpException;
import com.ty.online_event_management_web_app.exception.IdNotFoundByMenuException;
import com.ty.online_event_management_web_app.exception.IdNotFoundByPhotographerException;
import com.ty.online_event_management_web_app.exception.IdNotFoundByPurohithException;
import com.ty.online_event_management_web_app.exception.IdNotFoundByVenueException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByBandServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByCostumeServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByDecorationServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByMakeUpServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByMenuServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByOrganizerException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByPhotographerServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByPurohithServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByUserException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByUserOccassionServiceException;
import com.ty.online_event_management_web_app.exception.NoSuchElementFoundByVenueServiceException;
import com.ty.online_event_management_web_app.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	    // IdNotfindException
	
	// Band
			@ExceptionHandler(IdNotFoundByBandException.class)
			public ResponseEntity<ResponseStructure<String>> idNotFoundByBandException(IdNotFoundByBandException exception) {
				ResponseStructure<String> structure = new ResponseStructure<String>();

				structure.setMessage(exception.getMessage());
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setData(" Venue Id is Not Found There is No Data found for Id");
				return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
			}
			
			//Costume
			@ExceptionHandler(IdNotFoundByCostumeException.class)
			public ResponseEntity<ResponseStructure<String>> idNotFoundByCostumeException(IdNotFoundByCostumeException exception) {
				ResponseStructure<String> structure = new ResponseStructure<String>();

				structure.setMessage(exception.getMessage());
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setData(" Costume Id is Not Found There is No Data found for Id");
				return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
			}
			
			
			
			// Decoration
			@ExceptionHandler(IdNotFoundByDecorationException.class)
			public ResponseEntity<ResponseStructure<String>> idNotFoundByDecorationException(IdNotFoundByDecorationException exception) {
				ResponseStructure<String> structure = new ResponseStructure<String>();

				structure.setMessage(exception.getMessage());
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setData(" Decoration Id is Not Found There is No Data found for Id");
				return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
			}
			
			// MakeUp
			@ExceptionHandler(IdNotFoundByMakeUpException.class)
			public ResponseEntity<ResponseStructure<String>> idNotFoundByMakeUpException(
					IdNotFoundByMakeUpException exception) {
				ResponseStructure<String> structure = new ResponseStructure<String>();

				structure.setMessage(exception.getMessage());
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setData(" Venue Id is Not Found There is No Data found for Id");
				return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
			}
			
			// Menu
			@ExceptionHandler(IdNotFoundByMenuException.class)
			public ResponseEntity<ResponseStructure<String>> idNotFoundByMenuException(IdNotFoundByMenuException exception) {
				ResponseStructure<String> structure = new ResponseStructure<String>();

				structure.setMessage(exception.getMessage());
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setData(" Menu Id is Not Found There is No Data found for Id");
				return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
			}
	        
			// Photographer
			@ExceptionHandler(IdNotFoundByPhotographerException.class)
			public ResponseEntity<ResponseStructure<String>> idNotFoundByPhotographerException(
					IdNotFoundByPhotographerException exception) {
				ResponseStructure<String> structure = new ResponseStructure<String>();

				structure.setMessage(exception.getMessage());
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setData(" Venue Id is Not Found There is No Data found for Id");
				return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
			}
			// Purohith
			@ExceptionHandler(IdNotFoundByPurohithException.class)
			public ResponseEntity<ResponseStructure<String>> idNotFoundByPurohithException(
					IdNotFoundByPurohithException exception) {
				ResponseStructure<String> structure = new ResponseStructure<String>();

				structure.setMessage(exception.getMessage());
				structure.setStatus(HttpStatus.NOT_FOUND.value());
				structure.setData(" Venue Id is Not Found There is No Data found for Id");
				return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
			}
	
	
		// Venue
		@ExceptionHandler(IdNotFoundByVenueException.class)
		public ResponseEntity<ResponseStructure<String>> idNotFoundByVenueException(IdNotFoundByVenueException exception) {
			ResponseStructure<String> structure = new ResponseStructure<String>();

			structure.setMessage(exception.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(" Venue Id is Not Found There is No Data found for Id");
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		}

		

		

	

		

		
		
		

		// NoSuchElementException
		
		// Band
				@ExceptionHandler(NoSuchElementFoundByBandServiceException.class)
				public ResponseEntity<ResponseStructure<String>> noSuchElementException(
						NoSuchElementFoundByBandServiceException exception) {
					ResponseStructure<String> structure = new ResponseStructure<String>();

					structure.setMessage(exception.getMessage());
					structure.setStatus(HttpStatus.NOT_FOUND.value());
					structure.setData("No Such service is Found In Band  Entity ");
					return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
				}
				
				// costume
				@ExceptionHandler(NoSuchElementFoundByCostumeServiceException.class)
				public ResponseEntity<ResponseStructure<String>> noSuchElementException(
						NoSuchElementFoundByCostumeServiceException exception) {
					ResponseStructure<String> structure = new ResponseStructure<String>();

					structure.setMessage(exception.getMessage());
					structure.setStatus(HttpStatus.NOT_FOUND.value());
					structure.setData("No Such service is Found In Venue  Entity ");
					return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
				}
				
				// Decoration
				@ExceptionHandler(NoSuchElementFoundByDecorationServiceException.class)
				public ResponseEntity<ResponseStructure<String>> noSuchElementException(
						NoSuchElementFoundByDecorationServiceException exception) {
					ResponseStructure<String> structure = new ResponseStructure<String>();

					structure.setMessage(exception.getMessage());
					structure.setStatus(HttpStatus.NOT_FOUND.value());
					structure.setData("No Such service is Found In Decoration  Entity ");
					return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
				}
				

				// MakeUp
				@ExceptionHandler(NoSuchElementFoundByMakeUpServiceException.class)
				public ResponseEntity<ResponseStructure<String>> noSuchElementException(
						NoSuchElementFoundByMakeUpServiceException exception) {
					ResponseStructure<String> structure = new ResponseStructure<String>();

					structure.setMessage(exception.getMessage());
					structure.setStatus(HttpStatus.NOT_FOUND.value());
					structure.setData("No Such service is Found In MakeUp  Entity ");
					return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
				}
				
				// Menu
				@ExceptionHandler(NoSuchElementFoundByMenuServiceException.class)
				public ResponseEntity<ResponseStructure<String>> noSuchElementException(
						NoSuchElementFoundByMenuServiceException exception) {
					ResponseStructure<String> structure = new ResponseStructure<String>();

					structure.setMessage(exception.getMessage());
					structure.setStatus(HttpStatus.NOT_FOUND.value());
					structure.setData("No Such service is Found In Organizer Entity ");
					return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
				}
				// Organizer
				@ExceptionHandler(NoSuchElementFoundByOrganizerException.class)
				public ResponseEntity<ResponseStructure<String>> noSuchElementException(
						NoSuchElementFoundByOrganizerException exception) {
					ResponseStructure<String> structure = new ResponseStructure<String>();

					structure.setMessage(exception.getMessage());
					structure.setStatus(HttpStatus.NOT_FOUND.value());
					structure.setData("No Such Element is Found In Organizer Entity beacuse email is not Exist");
					return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
				}
				
				// Photographer
				@ExceptionHandler(NoSuchElementFoundByPhotographerServiceException.class)
				public ResponseEntity<ResponseStructure<String>> noSuchElementException(
						NoSuchElementFoundByPhotographerServiceException exception) {
					ResponseStructure<String> structure = new ResponseStructure<String>();

					structure.setMessage(exception.getMessage());
					structure.setStatus(HttpStatus.NOT_FOUND.value());
					structure.setData("No Such service is Found In Photographer  Entity ");
					return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
				}
				
				// Purohith
				@ExceptionHandler(NoSuchElementFoundByPurohithServiceException.class)
				public ResponseEntity<ResponseStructure<String>> noSuchElementException(
						NoSuchElementFoundByPurohithServiceException exception) {
					ResponseStructure<String> structure = new ResponseStructure<String>();

					structure.setMessage(exception.getMessage());
					structure.setStatus(HttpStatus.NOT_FOUND.value());
					structure.setData("No Such service is Found In Purohith  Entity ");
					return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
				}
		
		
		// User
		@ExceptionHandler(NoSuchElementFoundByUserException.class)
		public ResponseEntity<ResponseStructure<String>> noSuchElementException(
				NoSuchElementFoundByUserException exception) {
			ResponseStructure<String> structure = new ResponseStructure<String>();

			structure.setMessage(exception.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData("No Such Element is Found In User Entity beacuse email is not Exist");
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		}
		
		
		// UserOccassion
		@ExceptionHandler(NoSuchElementFoundByUserOccassionServiceException.class)
		public ResponseEntity<ResponseStructure<String>> noSuchElementException(
				NoSuchElementFoundByUserOccassionServiceException exception) {
			ResponseStructure<String> structure = new ResponseStructure<String>();

			structure.setMessage(exception.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData("No Such Element is Found In UserOccasion Entity beacuse email is not Exist");
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		}

		

	

		

		

	

		

		// Venue

		@ExceptionHandler(NoSuchElementFoundByVenueServiceException.class)
		public ResponseEntity<ResponseStructure<String>> noSuchElementException(
				NoSuchElementFoundByVenueServiceException exception) {
			ResponseStructure<String> structure = new ResponseStructure<String>();

			structure.setMessage(exception.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData("No Such service is Found In Venue  Entity ");
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		}

		

	//	
//		@Override
//		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//				HttpHeaders headers, HttpStatus status, WebRequest request) {
//			 List< ObjectError> error =ex.getAllErrors();
//			 Map< String , String> map=new HashMap<String, String>( );
//			 for(ObjectError objectError: error)
//			 {
//				 String filedName=((FieldError)objectError).getField();
//				 String message=((FieldError)objectError).getDefaultMessage();
//				 map.put(filedName, message);
//				 
//			 }
//			 return new ResponseEntity<Object> (map,HttpStatus.BAD_REQUEST);
//		}

//		    @ExceptionHandler(ConstraintViolationException.class)
//		    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
//		        StringBuilder errorMessage = new StringBuilder();
//		        ex.getConstraintViolations().forEach(violation ->
//		                errorMessage.append(violation.getMessage()).append("; "));
//		        return ResponseEntity.badRequest().body(errorMessage.toString());
//		    }

//		 @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
//		 public ResponseEntity<ResponseStructure<String>> sqlintegrityconstraintViolation(SQLIntegrityConstraintViolationException ex){
//			 
//			 ResponseStructure<String> structure = new ResponseStructure<String>();
	//
//				structure.setMessage(ex.getMessage());
//				structure.setStatus(HttpStatus.NOT_FOUND.value());
//				structure.setData("Cannot delete or update a parent row: a foreign key constraint fails.");
//				return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	//
	
	
		
	
	
	
	
	

}
