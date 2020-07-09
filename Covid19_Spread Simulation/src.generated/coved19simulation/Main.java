package coved19simulation;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import com.anylogic.engine.connectivity.ResultSet;
import com.anylogic.engine.connectivity.Statement;
import com.anylogic.engine.elements.*;
import com.anylogic.engine.markup.Network;
import com.anylogic.engine.Position;
import com.anylogic.engine.markup.PedFlowStatistics;
import com.anylogic.engine.markup.DensityMap;


import static java.lang.Math.*;
import static com.anylogic.engine.UtilitiesArray.*;
import static com.anylogic.engine.UtilitiesCollection.*;
import static com.anylogic.engine.presentation.UtilitiesColor.*;
import static com.anylogic.engine.HyperArray.*;

import com.anylogic.engine.*;
import com.anylogic.engine.analysis.*;
import com.anylogic.engine.connectivity.*;
import com.anylogic.engine.database.*;
import com.anylogic.engine.gis.*;
import com.anylogic.engine.markup.*;
import com.anylogic.engine.routing.*;
import com.anylogic.engine.presentation.*;
import com.anylogic.engine.gui.*;

import static coved19simulation.Age.*;
import static coved19simulation.Ethnicity.*;

import java.awt.geom.Arc2D;

 

public class Main extends Agent
{
  // Parameters

 
  public 
int  populationSize;

  /**
   * Returns default value for parameter <code>populationSize</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _populationSize_DefaultValue_xjal() {
    final Main self = this;
    return 
1000 
;
  }

  public void set_populationSize( int populationSize ) {
    if (populationSize == this.populationSize) {
      return;
    }
    int _oldValue_xjal = this.populationSize;
    this.populationSize = populationSize;
    onChange_populationSize_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter populationSize.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_populationSize()</code> method instead.
   */
  protected void onChange_populationSize() {
    onChange_populationSize_xjal( populationSize );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_populationSize_xjal( int oldValue ) {

slider.setValue( populationSize ); // 
;  
  }


 
  public 
double  infectionProb;

  /**
   * Returns default value for parameter <code>infectionProb</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _infectionProb_DefaultValue_xjal() {
    final Main self = this;
    return 
0.5 
;
  }

  public void set_infectionProb( double infectionProb ) {
    if (infectionProb == this.infectionProb) {
      return;
    }
    double _oldValue_xjal = this.infectionProb;
    this.infectionProb = infectionProb;
    onChange_infectionProb_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter infectionProb.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_infectionProb()</code> method instead.
   */
  protected void onChange_infectionProb() {
    onChange_infectionProb_xjal( infectionProb );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_infectionProb_xjal( double oldValue ) {

 
;  
  }


 
  public 
double  rate;

  /**
   * Returns default value for parameter <code>rate</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _rate_DefaultValue_xjal() {
    final Main self = this;
    return 
5/populationSize 
;
  }

  public void set_rate( double rate ) {
    if (rate == this.rate) {
      return;
    }
    double _oldValue_xjal = this.rate;
    this.rate = rate;
    onChange_rate_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter rate.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_rate()</code> method instead.
   */
  protected void onChange_rate() {
    onChange_rate_xjal( rate );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_rate_xjal( double oldValue ) {

 
;  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    populationSize = _populationSize_DefaultValue_xjal();
    infectionProb = _infectionProb_DefaultValue_xjal();
    rate = _rate_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "populationSize":
      if ( _callOnChange_xjal ) {
        set_populationSize( ((Number) _value_xjal).intValue() );
      } else {
        populationSize = ((Number) _value_xjal).intValue();
      }
      return true;
    case "infectionProb":
      if ( _callOnChange_xjal ) {
        set_infectionProb( ((Number) _value_xjal).doubleValue() );
      } else {
        infectionProb = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "rate":
      if ( _callOnChange_xjal ) {
        set_rate( ((Number) _value_xjal).doubleValue() );
      } else {
        rate = ((Number) _value_xjal).doubleValue();
      }
      return true;
    default:
      return super.setParameter( _name_xjal, _value_xjal, _callOnChange_xjal );
    }
  }

  @Override
  public <T> T getParameter(String _name_xjal) {
    Object _result_xjal;
    switch ( _name_xjal ) {
    case "populationSize": _result_xjal = populationSize; break;
    case "infectionProb": _result_xjal = infectionProb; break;
    case "rate": _result_xjal = rate; break;
    default: _result_xjal = super.getParameter( _name_xjal ); break;
    }
    return (T) _result_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private static String[] _parameterNames_xjal;

  @Override
  public String[] getParameterNames() {
    String[] result = _parameterNames_xjal;
    if (result == null) {
      List<String> list = new ArrayList<>( Arrays.asList( super.getParameterNames() ) );
      list.add( "populationSize" );
      list.add( "infectionProb" );
      list.add( "rate" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

 
  public 
int 
 infectedPopulation;
 
  public 
int 
 DesB;
 
  public 
int 
 curedPopulation;
 
  public 
int 
 deceasedPopulation;
 
  public 
int 
 DesW;
 
  public 
int 
 DesH;
 
  public 
int 
 DesO;
 
  public 
int 
 DesA;
 
  public 
int 
 Under18;
 
  public 
int 
 Age18to49;
 
  public 
int 
 Age50to64;
 
  public 
int 
 Age65to74;
 
  public 
double 
 Age75to84;
 
  public 
double 
 Ageovr85;
 
  public 
int 
 InfA;
 
  public 
int 
 InfB;
 
  public 
int 
 InfH;
 
  public 
int 
 InfO;
 
  public 
int 
 InfW;
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Main.class );
  
  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final Scale scale = new Scale( 10.0 );

  @Override
  public Scale getScale() {
    return scale;
  }


  // Events
	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart_autoUpdateEvent_xjal = new EventTimeout(this);	
  @AnyLogicInternalCodegenAPI
  public EventTimeout _chart1_autoUpdateEvent_xjal = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == _chart_autoUpdateEvent_xjal ) return "chart auto update event";
     if( _e == _chart1_autoUpdateEvent_xjal ) return "chart1 auto update event";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == _chart_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    if ( _e == _chart1_autoUpdateEvent_xjal ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == _chart_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    if ( _e == _chart1_autoUpdateEvent_xjal ) {
      _t = 
0 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    return super.getFirstOccurrenceTime( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( EventTimeout _e ) {
    double _t;
    if( _e == _chart_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    if( _e == _chart1_autoUpdateEvent_xjal) {
      _t = 
1 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    return super.evaluateTimeoutOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventTimeout _e ) {
    if ( _e == _chart_autoUpdateEvent_xjal ) {
      chart.updateData();
      return;
    }
    if ( _e == _chart1_autoUpdateEvent_xjal ) {
      chart1.updateData();
      return;
    }
    super.executeActionOf( _e );
  }

	

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 0;


  // Stub function for code completion support (internal)
  @AnyLogicInternalCodegenAPI
  private void _stubForCodeCompletion_xjal(){
    {double _t = 
0 
;}
    {double _t = 
1 
;}
    class _Stub_Implements_xjal implements 
  {}
    class _Stub_Extends_xjal extends 
  {}
  }

  // Embedded Objects

  @AnyLogicInternalCodegenAPI
  private static final AgentAnimationSettings _population_animationSettings_xjal = new AgentAnimationSettings(1000L, 1000000000L);

  public String getNameOf( Agent ao ) {
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    return super.getAnimationSettingsOf( ao );
  }

  public class _population_Population extends AgentArrayList<Person> {
    _population_Population( Agent owner ) {
      super( owner );
    }

    @AnyLogicInternalCodegenAPI
    public Person instantiateAgent( int index ) {
    	return instantiate_population_xjal( index );
    }

    @AnyLogicInternalCodegenAPI
    public void callSetupParameters( Person agent, int index, TableInput tableInput ) {
      setupParameters_population_xjal( agent, index, tableInput );
    }

    @AnyLogicInternalCodegenAPI
    public void callCreate( Person agent, int index, TableInput tableInput ) {
      doBeforeCreate_population_xjal( agent, index, tableInput );
      agent.create();
    }

    @AnyLogicInternalCodegenAPI
    public boolean isPresentationEnabled() {
      return true;
    }

  }
  
 
  @AnyLogicCustomProposalType(value = AnyLogicCustomProposalType.Label.POPULATION, customText = "Person")
  public _population_Population population = new _population_Population( this );

  public String getNameOf( AgentList<?> aolist ) {
    if( aolist == population ) return "population";
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    if( aolist == population ) return _population_animationSettings_xjal;
    return super.getAnimationSettingsOf( aolist );
  }

  /**
   * Returns the agent element at the specified position in population
   * population.
   * @see com.anylogic.engine.AgentList#get(int)
   * @since 7.3.7
   */
  public Person population(int index) {
    return population.get( index );
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection population<br>
   * @return newly created embedded object
   */
  public Person add_population() {
    int index = population.size();
    Person _result_xjal = instantiate_population_xjal( index );
    population.callSetupParameters( _result_xjal, index );
    population.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method creates and adds new embedded object in the replicated embedded object collection population<br>
   * This method uses given parameter values to setup created embedded object<br>
   * Index of this new embedded object instance can be obtained through calling <code>population.size()</code> method <strong>before</strong> this method is called
   * @param age
   * @param ethnicity
   * @return newly created embedded object
   */
  public Person add_population( int age, Ethnicity ethnicity ) {
    int index = population.size();
    Person _result_xjal = instantiate_population_xjal( index );
    // Setup parameters
    _result_xjal.markParametersAreSet();
    _result_xjal.age = age;
    _result_xjal.ethnicity = ethnicity;
    // Finish embedded object creation
    population.callCreate( _result_xjal, index );
    _result_xjal.start();
    return _result_xjal;
  }

  /**
   * This method removes the given embedded object from the replicated embedded object collection population<br>
   * The given object is destroyed, but not immediately in common case.
   * @param object the active object - element of replicated embedded object population - which should be removed
   * @return <code>true</code> if object was removed successfully, <code>false</code> if it doesn't belong to population
   */
  public boolean remove_population( Person object ) {
    if( ! population._remove( object ) ) {
      return false;
    }
    object.removeFromFlowchart();
    object.setDestroyed();
    return true;
  }

  /**
   * Creates an embedded object instance and adds it to the end of replicated embedded object list<br>
   * <i>This method should not be called by user</i>
   */
  protected Person instantiate_population_xjal( final int index ) {
    Person _result_xjal = new Person( getEngine(), this, population ) {
      // Additional class code

 
      // End of additional class code
	};
    
    population._add( _result_xjal );

    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_population_xjal( final Person self, final int index, TableInput _t ) {
    self.age = 
AgeDistribution() 
;
    self.ethnicity = 
RaceDistribution() 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void doBeforeCreate_population_xjal( Person self, final int index, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	double _length = 
1 
;
	self.setLength(_length, METER);
	double _width = 
1 
;
	self.setWidth(_width, METER);
	double _height = 
1 
;
	self.setHeight(_height, METER);
    self.setEnvironment( this );
    double _x_xjal = 
uniform(0,1000) 
;
    double _y_xjal = 
uniform(0,1000) 
;
    double _z_xjal = 
0 
;
    self.setXYZ( _x_xjal, _y_xjal, _z_xjal );
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );

    // Port connections
  }

  // Functions

 
  
double 
 infectionByAge( int age ) { 

double rate = 0.0;
if(age <= 18)
{
	//rate = 0.04;
	rate = 0.02;
}else if(age > 18 && age <= 49)
{
	//rate = 2.5 ;
	rate = 0.36;
}
else if(age > 50 && age <= 64)
{
	//rate = 7.4 ;
	rate = 0.37;
}
else if(age >= 65 && age <= 74)
{
	//rate = 12.2 ;
	rate = 0.11;
}
else if(age >= 75 && age <= 84)
{
	//rate = 15.8 ;
	rate = 0.12;
}
else 
{
	//rate = 17.2 ;
	rate = 0.03;
}


return rate; 
  }

 
  
double 
 infectionByRace( Ethnicity race ) { 

double rate = 0.0;
if(race.values().equals(Black))
{
	rate = 0.35;
}
else if(race.values().equals(White))
{
	rate = 0.42;
}
else if(race.values().equals(Hispanic))
{
	rate = 0.081;
}
else if(race.values().equals(Asian))
{
	rate = 0.055;
}
else
{
	rate = 0.083;
}
return rate; 
  }

 
  void getReportByRace( Ethnicity race ) { 

int countB = 0;
int countW = 0;
int countH = 0;
int countA = 0;
int countO = 0;
if(race == Black)
{
	countB++;	
	
}
else if(race == White)
{
	countW++;
	
}
else if(race == Hispanic)
{
	countH++;
}
else if(race == Asian)
{
	countA++;	
}
else
{
	countO++;	
}
traceln("White: " + countW);
traceln("Black: " + countB);
traceln("Hispanic: " + countH);
traceln("Asian: " + countA);
traceln("Others: " + countO);
// SEPARATE ALL THISE FUNCTIONS AND CREATE A NEW VAR IN MAIN AND INITIALIZE IN PERSON CLASS 
  }

 
  void getReportByAge( Age age ) { 

/*
double age18;
double age18to44;
double age45to64;
double age65to74;
double age75;
double ageOther;

if(age.values() < 18)
{
	age18;
}else if(age.values() <= 18 && age.values() <= 44)
{
	age18to44++;
}
else if(age.values() > 45 && age.values() <= 64)
{
	age45to64++;
}
else if(age.values() >= 65 && age.values() <= 74)
{
	age65to74++;
}
else if(age.values() >= 75)
{
	age75++;
}
else
{
	ageOther++;
}

*/ 
  }
  // Custom Distributions
  @AnyLogicInternalCodegenAPI
  private final static double[] _AgeDistribution_Arguments_xjal = _AgeDistribution_Arguments_xjal();
  @AnyLogicInternalCodegenAPI
  private final static double[] _AgeDistribution_Arguments_xjal() {
    return new double[] { 0.0, 19.0, 26.0, 35.0, 55.0, 65.0, 96.0,  };
  }
  @AnyLogicInternalCodegenAPI
  private final static double[] _AgeDistribution_Values_xjal = _AgeDistribution_Values_xjal();
  @AnyLogicInternalCodegenAPI
  private final static double[] _AgeDistribution_Values_xjal() {
    return new double[] { 0.24, 0.9, 12.0, 0.26, 13.0, 0.16, 0.0,  };
  }

  /**
   * AgeDistribution Custom Distribution
   */
  public CustomDistribution AgeDistribution = new CustomDistribution( _AgeDistribution_Arguments_xjal, _AgeDistribution_Values_xjal, this );

  public int AgeDistribution() { return AgeDistribution.getInt(); }

  @AnyLogicInternalCodegenAPI
  private final static Ethnicity[] _RaceDistribution_Arguments_xjal = _RaceDistribution_Arguments_xjal();
  @AnyLogicInternalCodegenAPI
  private final static Ethnicity[] _RaceDistribution_Arguments_xjal() {
    return new Ethnicity[] { Ethnicity.White, Ethnicity.Black, Ethnicity.Hispanic, Ethnicity.Asian, Ethnicity.MoreRace,  };
  }
  @AnyLogicInternalCodegenAPI
  private final static double[] _RaceDistribution_Values_xjal = _RaceDistribution_Values_xjal();
  @AnyLogicInternalCodegenAPI
  private final static double[] _RaceDistribution_Values_xjal() {
    return new double[] { 0.6, 0.13, 0.17, 0.06, 0.04,  };
  }

  /**
   * RaceDistribution Custom Distribution
   */
  public CustomDistributionOfOptions<Ethnicity> RaceDistribution = new CustomDistributionOfOptions<Ethnicity>( _RaceDistribution_Arguments_xjal, _RaceDistribution_Values_xjal, this );

  public Ethnicity RaceDistribution() { return RaceDistribution.get(); }

  // View areas
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1000.0, 600.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 1 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _calRateRace_Font = new Font("Dialog", 1, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _getReport_Font = new Font("Dialog", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _getAgeReport_Font = _getReport_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = new Font("SansSerif", 0, 10 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text5_Font = _text_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _calRateRace = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _getReport = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _getAgeReport = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _slider = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart1 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _population_presentation = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _text5 = 11;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 12;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  @AnyLogicInternalCodegenAPI
  private void _initialize_level_xjal() {
	  level.addAll(population_presentation, calRateRace, getReport, chart, getAgeReport, slider, text, text1, text3, text5, chart1);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _population_presentation:
        if (true) {
          
 
        }
        break;
      case _text:
        if (true) {
          ShapeText self = this.text;
          
 
        }
        break;
      case _text1:
        if (true) {
          ShapeText self = this.text1;
          
 
        }
        break;
      case _text3:
        if (true) {
          ShapeText self = this.text3;
          
 
        }
        break;
      case _text5:
        if (true) {
          ShapeText self = this.text5;
          
 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index ) {
    switch( _shape ) {
      case _calRateRace: {
          ShapeButton self = this.calRateRace;
traceln("Total Population: " + population.size() );

InfW = count( population, p -> p.ethnicity == White );
traceln("White: " + InfW);

InfB = count( population, p -> p.ethnicity == Black );
traceln("Black: " + InfB);

InfH = count( population, p -> p.ethnicity == Hispanic );
traceln("Hispanic: " + InfH);

InfA = count( population, p -> p.ethnicity == Asian );
traceln("Asian: " + InfA);

InfO = count( population, p -> p.ethnicity == MoreRace );
traceln("Others: " + InfO);
traceln(""); 
;}
        break;
      case _getReport: {
          ShapeButton self = this.getReport;
traceln(" ");
traceln("Mortality of populattion By Race");
traceln("Total Death in population: " + deceasedPopulation);
traceln("White: " + DesW);
traceln("Black: " + DesB);
traceln("Hispanic: " + DesH);
traceln("Asian: " + DesA);
traceln("Others: " + DesO);
traceln(" "); 
;}
        break;
      case _getAgeReport: {
          ShapeButton self = this.getAgeReport;
traceln(" ");
traceln("Total Cured population after Infection "+ curedPopulation );
traceln("Infection By Age");
traceln("Age Under 18: " + Under18);
traceln("Age 18 - 44: " + Age18to49);
traceln("Age 50 - 64: " + Age50to64);
traceln("Age 65 - 74: " + Age65to74);
traceln("Age 75 - 84: " + Age75to84);
traceln("Age Over 85 " + Ageovr85);
traceln(" "); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, double value ) {
    switch( _shape ) {
      case _slider:
        set_populationSize( (int) value ); {
          ShapeSlider self = this.slider;
// setValue( populationSize, true); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }
         
  @Override
  @AnyLogicInternalCodegenAPI
  public void onSelectionChanged_xjal( int _shape, int index, int[] selectedIndices, boolean programmatically ) {
    switch( _shape ) {
      case _chart: {
        PieChart self = this.chart;
        
 
;}
        break;
      case _chart1: {
        BarChart self = this.chart1;
        
 
;}
        break;
      default:
        super.onSelectionChanged_xjal( _shape, index, selectedIndices, programmatically );
        break;
    }
  }


  @Override
  @AnyLogicInternalCodegenAPI
  public double getShapeControlDefaultValueDouble( int _shape, int index ) {
    switch(_shape) {
      case _slider: return 
populationSize 
;
      default: return super.getShapeControlDefaultValueDouble( _shape, index );
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_DataItem0Value() {
    return 
DesB  // / InfB 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_DataItem1Value() {
    return 
DesW  // / InfW 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_DataItem2Value() {
    return 
DesH   // /InfH 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_DataItem3Value() {
    return 
DesA // /InfA 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart_DataItem4Value() {
    return 
DesO // /InfO 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart1_DataItem0Value() {
    return 
Under18 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart1_DataItem1Value() {
    return 
Age18to49 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart1_DataItem2Value() {
    return 
Age50to64 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart1_DataItem3Value() {
    return 
Age65to74 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart1_DataItem4Value() {
    return 
Age75to84 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _chart1_DataItem5Value() {
    return 
Ageovr85 
;
  }
  // Stub function for code completion support (internal)
  @AnyLogicInternalCodegenAPI
  private void _stubForReplication_xjal() {
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _calRateRace_SetDynamicParams_xjal( ShapeButton shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
    shape.setText(
 
);
 	}
  }
  
  protected ShapeButton calRateRace;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _getReport_SetDynamicParams_xjal( ShapeButton shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
    shape.setText(
 
);
 	}
  }
  
  protected ShapeButton getReport;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _getAgeReport_SetDynamicParams_xjal( ShapeButton shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
    shape.setText(
 
);
 	}
  }
  
  protected ShapeButton getAgeReport;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _slider_SetDynamicParams_xjal( ShapeSlider shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    {
      @AnyLogicInternalCodegenAPI
      double _min = 
100 ;
      @AnyLogicInternalCodegenAPI
      double _max = 
50000 ;
      shape.setRange( _min, _max );
    }
 	}
  }
  
  protected ShapeSlider slider;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _chart_SetDynamicParams_xjal( PieChart shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
 	}
  }
  
  protected PieChart chart;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _chart1_SetDynamicParams_xjal( BarChart shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
 	}
  }
  
  protected BarChart chart1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _population_presentation_SetDynamicParams_xjal( ShapeEmbeddedObjectPresentation shape, int index ) {
    boolean _visible = _population_presentation_Visible();
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setRotation(
 
);
 	}
  }
  
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private boolean _population_presentation_Visible() {
    return 
 
;
  }
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  protected ShapeEmbeddedObjectPresentation _population_presentation_createShapeWithStaticProperties_xjal( final Agent _a, final int _index ) {
    ShapeEmbeddedObjectPresentation shape = new ShapeEmbeddedObjectPresentation( Main.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
		false, true, _a );

    return shape;
  }

  protected ShapeAgentPopulationGroup population_presentation;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
slider.getMin() 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text1_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
slider.getMax() 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text3_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
slider.getMin() 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text5_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
slider.getValue() 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text5;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    calRateRace = new ShapeButton(
			Main.this, true, 650.0, -280.0, 
			240.0, 30.0,
            blue, true,
            _calRateRace_Font, 
			"PopulationBrakeDownByRace" ) {
      @Override
      public void updateDynamicProperties() {
        _calRateRace_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _calRateRace, 0 );
      }
    };

    getReport = new ShapeButton(
			Main.this, true, 650.0, -240.0, 
			240.0, 30.0,
            red, true,
            _getReport_Font, 
			"MortalityReportByRace" ) {
      @Override
      public void updateDynamicProperties() {
        _getReport_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _getReport, 0 );
      }
    };

    getAgeReport = new ShapeButton(
			Main.this, true, 650.0, -200.0, 
			240.0, 30.0,
            purple, true,
            _getAgeReport_Font, 
			"InfectionReportByAge" ) {
      @Override
      public void updateDynamicProperties() {
        _getAgeReport_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _getAgeReport, 0 );
      }
    };

    slider = new ShapeSlider(
		    Main.this, true, 670.0, -160.0, 
			210.0, 30.0,
            true, false,
            100
            , 50000
            , ShapeControl.TYPE_INT ) {
      @Override
      public void updateDynamicProperties() {
        _slider_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action() {
        executeShapeControlAction( _slider, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setValue( limit( getMin(), getShapeControlDefaultValueDouble( _slider, 0 ), getMax() ) );
      }
    };

    text = new ShapeText(
        SHAPE_DRAW_2D, true,670.0, -130.0, 0.0, 0.0, 
        black,"min",
        _text_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    text1 = new ShapeText(
        SHAPE_DRAW_2D, true,880.0, -130.0, 0.0, 0.0, 
        black,"max",
        _text1_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties() {
        _text1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    text3 = new ShapeText(
        SHAPE_DRAW_2D, true,670.0, -130.0, 0.0, 0.0, 
        black,"min",
        _text3_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties() {
        _text3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    text5 = new ShapeText(
        SHAPE_DRAW_2D, true,770.0, -130.0, 0.0, 0.0, 
        black,"value",
        _text5_Font, ALIGNMENT_CENTER ) {
      @Override
      public void updateDynamicProperties() {
        _text5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    List<DataItem> _items = new ArrayList<DataItem>( 5 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_DataItem3Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart_DataItem4Value() );
      }
    });
    List<String> _titles = new ArrayList<String>( 5 );
    _titles.add( "Black" );
    _titles.add( "White" );
    _titles.add( "Hispanic" );
    _titles.add( "Asian" );
    _titles.add( "Others" );
    List<Color> _colors = new ArrayList<Color>( 5 );
    _colors.add( oliveDrab );
    _colors.add( deepSkyBlue );
    _colors.add( mediumOrchid );
    _colors.add( crimson );
    _colors.add( gold );
    chart = new PieChart(
		    Main.this, true, 220.0, -330.0, 
			390.0, 320.0,
            null, null,
            60.0, 10.0,
			270.0, 230.0, null, black,
            60.0, Chart.SOUTH,
            _items, _titles, _colors ) {
      @Override
      public void updateDynamicProperties() {
        _chart_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    }
    {
    List<DataItem> _items = new ArrayList<DataItem>( 6 );
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart1_DataItem0Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart1_DataItem1Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart1_DataItem2Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart1_DataItem3Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart1_DataItem4Value() );
      }
    });
    _items.add( new DataItem() {
      @Override
      public void update() {
        setValue( _chart1_DataItem5Value() );
      }
    });
    List<String> _titles = new ArrayList<String>( 6 );
    _titles.add( "Under 18" );
    _titles.add( "18 - 49" );
    _titles.add( "50 - 64" );
    _titles.add( "65 - 74" );
    _titles.add( "75 - 84" );
    _titles.add( "over 85" );
    List<Color> _colors = new ArrayList<Color>( 6 );
    _colors.add( slateBlue );
    _colors.add( chocolate );
    _colors.add( goldenRod );
    _colors.add( oliveDrab );
    _colors.add( deepSkyBlue );
    _colors.add( mediumOrchid );
    chart1 = new BarChart(
		    Main.this, true, 100.0, -580.0, 
			820.0, 240.0,
            null, null,
            50.0, 30.0,
			740.0, 150.0, white, black, black,
            30.0, Chart.SOUTH,
            Chart.NORTH, Chart.SCALE_AUTO,
            0, 0, 0.8,
            Chart.GRID_DEFAULT,
            darkGray, darkGray, _items, _titles, _colors ) {
      @Override
      public void updateDynamicProperties() {
        _chart1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

    }
    population_presentation = new ShapeAgentPopulationGroup(this, SHAPE_DRAW_2D3D, true, population) {
    
      @Override
      public ShapeEmbeddedObjectPresentation createShapeWithStaticProperties_xjal( final Agent _a, int index ) {
        ShapeEmbeddedObjectPresentation _e = _population_presentation_createShapeWithStaticProperties_xjal( _a, index );
        return _e;
      }
      
      @Override
      public void setShapeDynamicProperties_xjal( ShapeEmbeddedObjectPresentation shape, int index ) {
        _population_presentation_SetDynamicParams_xjal( shape, index );
      }
    };
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBS0_xjal() {
  }


  // Static initialization of persistent elements
  {
    level = new com.anylogic.engine.markup.Level(this, "level", SHAPE_DRAW_2D3D, 0.0, true, true);  			
	_getLevels_xjal = new com.anylogic.engine.markup.Level[] { 
      level };
    _createPersistentElementsBP0_xjal();
  }
  protected ShapeTopLevelPresentationGroup presentation;
  protected ShapeModelElementsGroup icon; 

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeTopLevelPresentationGroup getPresentationShape() {
    return presentation;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeModelElementsGroup getModelElementsShape() {
    return icon;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onArrival() {
    super.onArrival();
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onStep() {
    super.onStep();
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onBeforeStep() {
    super.onBeforeStep();
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onEnterFlowchartBlock(Agent oldBlock, Agent block) {
    super.onEnterFlowchartBlock( oldBlock, block );
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onExitFlowchartBlock(Agent block) {
    super.onExitFlowchartBlock(block);
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onSeizeResource(Agent unit) {
    super.onSeizeResource(unit);
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onReleaseResource(Agent unit) {
    super.onReleaseResource(unit);
    
 
  }

  /**
   * Constructor
   */
  public Main( Engine engine, Agent owner, AgentList<? extends Main> ownerPopulation ) {
    super( engine, owner, ownerPopulation );
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    instantiateBaseStructureThis_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void instantiateBaseStructureThis_xjal() {
    setupReferences_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Main() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Main( int populationSize, double infectionProb, double rate ) {
    markParametersAreSet();
    this.populationSize = populationSize;
    this.infectionProb = infectionProb;
    this.rate = rate;
  }
  
  /**
   * Creating embedded object instances
   */
  @AnyLogicInternalCodegenAPI
  private void instantiatePopulations_xjal() {
    {
      int _cnt = 
populationSize 
;
      for ( int i = population.size(); i < _cnt; i++ ) {
        instantiate_population_xjal( i );
      }
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Creating embedded object instances
    instantiatePopulations_xjal();
    // Assigning initial values for plain variables
    setupPlainVariables_Main_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Main.this, true, 0, 0, 0, 0 , level );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Main.this, getElementProperty( "coved19simulation.Main.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
    // Environments setup
    {
      double _x_xjal = 
500 
;
      double _y_xjal = 
500 
;
      double _z_xjal = 
0 
;
      setupSpace( _x_xjal, _y_xjal, _z_xjal );
    }
    disableSteps();
    setNetworkUserDefined();
    setLayoutType( LAYOUT_USER_DEFINED );
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    population.setEnvironment( this );
    for ( int i = 0; i < population.size(); i++ ) {
      Person _a = population.get(i); 
      setupParameters_population_xjal( _a, i, null );
      doBeforeCreate_population_xjal( _a, i, null );
      _a.createAsEmbedded();
    }
    setupInitialConditions_xjal( Main.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
    slider.setValueToDefault();
  }

  @AnyLogicInternalCodegenAPI
  public void setupExt_xjal(AgentExtension _ext) {
    // Agent properties setup
    if ( _ext instanceof ExtAgentWithSpatialMetrics && _ext instanceof ExtWithSpaceType && !(tryExt(ExtAgentWithSpatialMetrics.class) instanceof ExtWithSpaceType) ) {
      double _speed;
      _speed = 
10 
;
      ((ExtAgentWithSpatialMetrics) _ext).setSpeed( _speed, MPS );
    }
    if ( _ext instanceof ExtEntity && tryExt(ExtEntity.class) == null ) {
      ExtEntity _e = (ExtEntity) _ext;
      double _length;
      _length = 
1 
;
	  _e.setLength( _length, METER );
	  double _width;
      _width = 
1 
;
	  _e.setWidth( _width, METER );
	  double _height;
      _height = 
1 
;
	  _e.setHeight( _height, METER );
    }
    if ( _ext instanceof ExtAgentWithSpatialMetrics && tryExt(ExtAgentWithSpatialMetrics.class) == null ) {
      ExtAgentWithSpatialMetrics _e = (ExtAgentWithSpatialMetrics) _ext;
      _e.setAutomaticHorizontalRotation( true );
    }
    if ( _ext instanceof ExtAgentContinuous && tryExt(ExtAgentContinuous.class) == null ) {
      ExtAgentContinuous _e = (ExtAgentContinuous) _ext;
      _e.setAutomaticVerticalRotation( false );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    _chart_autoUpdateEvent_xjal.start();
    _chart1_autoUpdateEvent_xjal.start();
    for (Agent embeddedObject : population) {
      embeddedObject.startAsEmbedded();
    }
  }
 
  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();
    
//deliverToRandomAgentInside( "Infection" ); 
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Main_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Main_xjal() {
    infectedPopulation = 
 
;
    DesB = 
 
;
    curedPopulation = 
 
;
    deceasedPopulation = 
 
;
    DesW = 
 
;
    DesH = 
 
;
    DesO = 
 
;
    DesA = 
 
;
    Under18 = 
 
;
    Age18to49 = 
 
;
    Age50to64 = 
 
;
    Age65to74 = 
 
;
    Age75to84 = 
 
;
    Ageovr85 = 
 
;
    InfA = 
 
;
    InfB = 
 
;
    InfH = 
 
;
    InfO = 
 
;
    InfW = 
 
;
  }

  // User API -----------------------------------------------------
  @AnyLogicInternalCodegenAPI
  public static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public void onReceive( Object _msg_xjal, Agent _sender_xjal ) {
    super.onReceive( _msg_xjal, _sender_xjal );
    
Object  msg = (Object) _msg_xjal;
    Agent sender = _sender_xjal;
    
 
  }



  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<Object>();
    }
    list.add( population );
    return list;
  }

  public AgentList<? extends Main> getPopulation() {
    return (AgentList<? extends Main>) super.getPopulation();
  }

  public List<? extends Main> agentsInRange( double distance ) {
    return (List<? extends Main>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == _chart_autoUpdateEvent_xjal ) return false;
    if ( _e == _chart1_autoUpdateEvent_xjal ) return false;
    return super.isLoggingToDB( _e );
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    _chart_autoUpdateEvent_xjal.onDestroy();
    _chart1_autoUpdateEvent_xjal.onDestroy();
    for (Agent _item : population) {
      _item.onDestroy();
    }
    // On destroy code
    
 
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    super.doFinish();
    for (Agent _item : population) {
      _item.doFinish();
    }
  }

  // Additional class code

 
  // End of additional class code


}
