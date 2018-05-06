package tomislavt.extensions.AnimationExtension;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.Form;

@DesignerComponent(version = 2,
                   description = " A component to animate views",
                   category = ComponentCategory.EXTENSION,
                   nonVisible = true,
                   iconName = "aiwebres/bluerect16.png")
@SimpleObject(external = true)
public class AnimationExtension extends AndroidNonvisibleComponent {

  private final Activity context;
  private final Form form;

  public AnimationExtension(ComponentContainer container) {
    super(container.$form());
    context = container.$context();
    form = container.$form();

  }

  @SimpleFunction(description = "Rotates component for a given degree.")
  public void ComponentRotation(AndroidViewComponent component, float Degree) {

    View a = component.getView();

    a.animate().rotationBy(Degree).setDuration(0).start();

  }

  @SimpleFunction(description = "Scales component for given X and Y percent values, and in a given time frame.")
  public void TimelyScaleComponent(
                                   AndroidViewComponent component,
                                   int ForXValue,
                                   int ForYValue,
                                   long Duration) {

    View a = component.getView();

    float xv = 0.0f;
    float yv = xv = 0.0f;

    if (ForXValue == 0) {
      xv = 0.0f;
    } else {
      xv = (float) ForXValue / 100;
    }

    if (ForYValue == 0) {
      yv = 0.0f;
    } else {
      yv = (float) ForYValue / 100;
    }

    a.animate().scaleXBy(xv).scaleYBy(yv).setDuration(Duration).start();

  }

  @SimpleFunction(description = "Rotates component for a given degree, in a given time frame. ")
  public void TimelyComponentRotation(AndroidViewComponent component, float Degree, long Duration) {

    View a = component.getView();

    a.animate().rotationBy(Degree).setDuration(Duration).start();

  }

  @SimpleFunction(description = "Makes component transparent for a given percent value, and in a given time frame ")
  public void TimelyComponentTransparency(AndroidViewComponent component, float Value, long Duration) {

    View a = component.getView();

    a.animate().alphaBy(Value).setDuration(Duration).start();

  }

  @SimpleFunction(description = "Treats Component as an object, thus click events etc, will continue to work. will continue to work when translated by X coordinates. ")
  public void ComponentAsObjectXMove(
                                     AndroidViewComponent component,
                                     float FromX,
                                     float ToX,
                                     long Duration) {

    View ao = component.getView();

    ObjectAnimator transAnimation = ObjectAnimator.ofFloat(ao, "translationX", FromX, ToX);
    transAnimation.setDuration(Duration);// set duration
    transAnimation.start();// start animation

  }

  @SimpleFunction(description = "Treats Component as an object, thus click events etc, will continue to work when translated by Y coordinates. ")
  public void ComponentAsObjectYMove(
                                     AndroidViewComponent component,
                                     float FromY,
                                     float ToY,
                                     long Duration) {

    View ao = component.getView();

    ObjectAnimator transAnimation = ObjectAnimator.ofFloat(ao, "translationY", FromY, ToY);
    transAnimation.setDuration(Duration);// set duration
    transAnimation.start();// start animation

  }

  @SimpleFunction(description = "Put component to precise coordinates. ")
  public void PutComponentTo(AndroidViewComponent component, float x, float y) {

    View ao = component.getView();

    ao.animate().x(x).y(y).start();

  }

  @SimpleFunction(description = "Device dependent, puts component by pixels. ")
  public void PutComponentByPixels(AndroidViewComponent component, float x, float y) {

    View ao = component.getView();

    ao.animate().xBy(x).yBy(y).start();

  }

}
