import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckpostsComponent } from './checkposts.component';

describe('CheckpostsComponent', () => {
  let component: CheckpostsComponent;
  let fixture: ComponentFixture<CheckpostsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckpostsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckpostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
