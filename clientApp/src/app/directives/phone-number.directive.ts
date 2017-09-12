import { Directive, Input, OnInit } from '@angular/core';
import { AbstractControl, ValidatorFn, NG_VALIDATORS, Validator, FormControl } from '@angular/forms';

// validation function
function validateZeroBeginningNumberFactory(digitsNumber) : ValidatorFn {
	return (c: AbstractControl) => {

		let regexp = new RegExp("^\\d{"+digitsNumber+"}$");
		let isValid = regexp.test(c.value) == true;
		console.log(digitsNumber);

		if(isValid) {
		    return null;
		} else {
		    return {
		        zeroBeginningNumber: {
		            valid: false
		        }
		    };
		}
	}
}

@Directive({
  selector: '[zeroBeginningNumber][ngModel]',
  providers: [{provide: NG_VALIDATORS, useExisting: PhoneNumberDirective, multi: true}]
})
export class PhoneNumberDirective implements Validator {

	validator: ValidatorFn;
	@Input('zeroBeginningNumber') digitsNumber: number;

	ngOnInit() {
		this.validator = validateZeroBeginningNumberFactory(this.digitsNumber);
	}

	validate(c: FormControl) {
		return this.validator(c);
	}

}


