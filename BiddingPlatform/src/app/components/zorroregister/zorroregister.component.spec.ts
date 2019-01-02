import { fakeAsync, ComponentFixture, TestBed } from '@angular/core/testing';
import { ZorroregisterComponent } from './zorroregister.component';

describe('ZorroregisterComponent', () => {
  let component: ZorroregisterComponent;
  let fixture: ComponentFixture<ZorroregisterComponent>;

  beforeEach(fakeAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ZorroregisterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ZorroregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should compile', () => {
    expect(component).toBeTruthy();
  });
});
