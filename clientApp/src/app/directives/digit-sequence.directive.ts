import { Directive, Input, OnInit } from '@angular/core';
import { AbstractControl, ValidatorFn, NG_VALIDATORS, Validator, FormControl } from '@angular/forms';

// validation function
function validateDigitSequenceFactory(digitsNumber) : ValidatorFn {
	return (c: AbstractControl) => {

		let regexp = new RegExp("^\\d{"+digitsNumber+"}$");
		let isValid = regexp.test(c.value) == true;

		/* checking if the value is valid
		I want the field to be also valid if no value was specified (undefined),
		or the value was specified and then removed ("") */
		/*if(isValid || c.value === undefined || c.value === "") {*/
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
  selector: '[digitSequence][ngModel]',
  providers: [{provide: NG_VALIDATORS, useExisting: DigitSequenceDirective, multi: true}]
})
export class DigitSequenceDirective implements Validator {

	validator: ValidatorFn;
	@Input('digitSequence') digitsNumber: number;

	ngOnInit() {
		this.validator = validateDigitSequenceFactory(this.digitsNumber);
	}

	validate(c: FormControl) {
		return this.validator(c);
	}

}


