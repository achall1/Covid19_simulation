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

 

public class Person extends Agent
{
  // Parameters

 
  public 
int  age;

  /**
   * Returns default value for parameter <code>age</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _age_DefaultValue_xjal() {
    final Person self = this;
    return 
 
;
  }

  public void set_age( int age ) {
    if (age == this.age) {
      return;
    }
    int _oldValue_xjal = this.age;
    this.age = age;
    onChange_age_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter age.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_age()</code> method instead.
   */
  protected void onChange_age() {
    onChange_age_xjal( age );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_age_xjal( int oldValue ) {

 
;  
  }


 
  public 
Ethnicity  ethnicity;

  /**
   * Returns default value for parameter <code>ethnicity</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Ethnicity _ethnicity_DefaultValue_xjal() {
    final Person self = this;
    return 
 
;
  }

  public void set_ethnicity( Ethnicity ethnicity ) {
    if (ethnicity == this.ethnicity) {
      return;
    }
    Ethnicity _oldValue_xjal = this.ethnicity;
    this.ethnicity = ethnicity;
    onChange_ethnicity_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter ethnicity.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_ethnicity()</code> method instead.
   */
  protected void onChange_ethnicity() {
    onChange_ethnicity_xjal( ethnicity );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_ethnicity_xjal( Ethnicity oldValue ) {

 
;  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    age = _age_DefaultValue_xjal();
    ethnicity = _ethnicity_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "age":
      if ( _callOnChange_xjal ) {
        set_age( ((Number) _value_xjal).intValue() );
      } else {
        age = ((Number) _value_xjal).intValue();
      }
      return true;
    case "ethnicity":
      if ( _callOnChange_xjal ) {
        set_ethnicity( (Ethnicity) _value_xjal );
      } else {
        ethnicity = (Ethnicity) _value_xjal;
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
    case "age": _result_xjal = age; break;
    case "ethnicity": _result_xjal = ethnicity; break;
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
      list.add( "age" );
      list.add( "ethnicity" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

 
  public 
Color 
 color;
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Person.class );
  
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



	

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _STATECHART_COUNT_xjal = 1;


  // Statecharts
  public Statechart<covid19Unemployment_state> covid19Unemployment = new Statechart<>( this, (short)2 );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( Statechart _s ) {
    if(_s == this.covid19Unemployment) return "covid19Unemployment";
    return super.getNameOf( _s );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public int getIdOf( Statechart _s ) {
    if(_s == this.covid19Unemployment) return 0;
    return super.getIdOf( _s );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( Statechart _s ) {
    if( _s == this.covid19Unemployment ) {
       Statechart<covid19Unemployment_state> self = this.covid19Unemployment;
       
 
;
      enterState( Exposed, true );
      return;
    }
    super.executeActionOf( _s );
  }

   // States of all statecharts
   
  public enum covid19Unemployment_state implements IStatechartState<Person, covid19Unemployment_state> {
    Exposed,
    Infected,
    Cured,
    Dead;

    @AnyLogicInternalCodegenAPI
    private Collection<covid19Unemployment_state> _simpleStatesDeep_xjal;

    @AnyLogicInternalCodegenAPI
    private Set<covid19Unemployment_state> _fullState_xjal;

    @AnyLogicInternalCodegenAPI
    private Set<covid19Unemployment_state> _statesInside_xjal;

    @Override
    @AnyLogicInternalCodegenAPI
    public Collection<covid19Unemployment_state> getSimpleStatesDeep() {
      Collection<covid19Unemployment_state> result = _simpleStatesDeep_xjal;
      if (result == null) {
        _simpleStatesDeep_xjal = result = calculateAllSimpleStatesDeep();
      }
      return result;
    }
    
    @Override
    public Set<covid19Unemployment_state> getFullState() {
      Set<covid19Unemployment_state> result = _fullState_xjal;
      if (result == null) {
        _fullState_xjal = result = calculateFullState();
      }
      return result;
    }
    
    @Override
    @AnyLogicInternalCodegenAPI
    public Set<covid19Unemployment_state> getStatesInside() {
      Set<covid19Unemployment_state> result = _statesInside_xjal;
      if (result == null) {
        _statesInside_xjal = result = calculateStatesInside();
      }
      return result;
    }

    @Override
    @AnyLogicInternalCodegenAPI
    public Statechart<covid19Unemployment_state> getStatechart( Person _a ) {
      return _a.covid19Unemployment;
    }
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final covid19Unemployment_state Exposed = covid19Unemployment_state.Exposed;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final covid19Unemployment_state Infected = covid19Unemployment_state.Infected;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final covid19Unemployment_state Cured = covid19Unemployment_state.Cured;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final covid19Unemployment_state Dead = covid19Unemployment_state.Dead;


  @AnyLogicInternalCodegenAPI
  private void enterState( covid19Unemployment_state self, boolean _destination ) {
    switch( self ) {
      case Exposed:
  	    logToDBEnterState(covid19Unemployment, self);
        // (Simple state (not composite))
        covid19Unemployment.setActiveState_xjal( Exposed );
        {
color = GREEN;
//main.InfW = count( main.population, p -> p.ethnicity == White );
 
;}
        Sustransition.start();
        return;
      case Infected:
  	    logToDBEnterState(covid19Unemployment, self);
        // (Simple state (not composite))
        covid19Unemployment.setActiveState_xjal( Infected );
        {
color = RED; 

if(age < 18){ main.Under18++; }
else if(age <= 18 && age <= 49){ main.Age18to49++; }
else if(age >= 50 && age <= 64){ main.Age50to64++;}
else if(age >= 65 && age <= 74){main.Age65to74++;}
else if(age >= 75 && age <= 84){ main.Age75to84++;}
else{main.Ageovr85++;}
main.infectedPopulation++;
 
;}
        Infectedtrans.start();
        Dtrans.start();
        return;
      case Cured:
  	    logToDBEnterState(covid19Unemployment, self);
        // (Simple state (not composite))
        covid19Unemployment.setActiveState_xjal( Cured );
        {
color = BLUE;
main.curedPopulation++;
 
;}
        return;
      case Dead:
  	    logToDBEnterState(covid19Unemployment, self);
        // (Simple state (not composite))
        covid19Unemployment.setActiveState_xjal( Dead );
        {
color = GRAY;
main.populationSize--;
main.deceasedPopulation++;
if(ethnicity == Asian){ main.DesA++; }
if(ethnicity == Hispanic){ main.DesH++; }
if(ethnicity == Black){ main.DesB++; }
if(ethnicity == White){ main.DesW++; }
if(ethnicity == MoreRace){ main.DesO++; }
/***************/

/*if(ethnicity == Hispanic){ main.DesH++; }
if(ethnicity == Black){ main.DesB++; }
if(ethnicity == White){ main.DesW++; }
if(ethnicity == MoreRace){ main.DesO++; }*/

 
;}
        return;
      default:
        return;
    }
  }

  @AnyLogicInternalCodegenAPI
  private void exitState( covid19Unemployment_state self, Transition _t, boolean _source ) {
    switch( self ) {
      case Exposed: 
  	    logToDBExitState(covid19Unemployment, self);
  	    logToDB(covid19Unemployment, _t, self);
      // (Simple state (not composite))
        if ( !_source || _t != Sustransition) Sustransition.cancel();
        {
 
;}
        return;
      case Infected: 
  	    logToDBExitState(covid19Unemployment, self);
  	    logToDB(covid19Unemployment, _t, self);
      // (Simple state (not composite))
        if ( !_source || _t != Infectedtrans) Infectedtrans.cancel();
        if ( !_source || _t != Dtrans) Dtrans.cancel();
        {
/*main.infectedPopulation++;
if(age < 18){ main.Under18++; }
else if(age <= 18 && age <= 49){ main.Age18to49++; }
else if(age >= 50 && age <= 64){ main.Age50to64++;}
else if(age >= 65 && age <= 74){main.Age65to74++;}
else if(age >= 75 && age <= 84){ main.Age75to84++;}
else{main.Ageovr85++;}*/ 
;}
        return;
      case Cured: 
  	    logToDBExitState(covid19Unemployment, self);
  	    logToDB(covid19Unemployment, _t, self);
      // (Simple state (not composite))
        {
 
;}
        return;
      case Dead: 
  	    logToDBExitState(covid19Unemployment, self);
  	    logToDB(covid19Unemployment, _t, self);
      // (Simple state (not composite))
        {
 
;}
        return;
      default:
        return;
    }
  }

  @AnyLogicInternalCodegenAPI
  private void exitInnerStates( covid19Unemployment_state _destination ) {
    covid19Unemployment_state _state = covid19Unemployment.getActiveSimpleState();
    while( _state != _destination ) {
			exitState( _state, null, false );
			_state = _state.getContainerState();
		}
	}
  
  public TransitionTimeout Infectedtrans = new TransitionTimeout( this );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( TransitionTimeout _t ) {
    if ( _t == Infectedtrans ) return "Infectedtrans";
    return super.getNameOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf( TransitionTimeout _t ) { 
    if ( _t == Infectedtrans ) return covid19Unemployment;
    return super.getStatechartOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testGuardOf( TransitionTimeout _t ) {
    if ( _t == Infectedtrans ) return 
 
;
    return super.testGuardOf(  _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( TransitionTimeout self ) {
    if ( self == Infectedtrans ) {
      exitState( Infected, self, true );
      {
 
;}
          enterState( Cured, true );
      return;
    }
    super.executeActionOf( self );
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( TransitionTimeout _t ) {
    double _value;
    if ( _t == Infectedtrans ) {
      _value = 
14 
;
      _value = toModelTime( _value, DAY );
      return _value;
    }
    return super.evaluateTimeoutOf( _t );
  }


  public TransitionRate Sustransition = new TransitionRate( this );
  public TransitionRate Dtrans = new TransitionRate( this );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( TransitionRate _t ) {
    if ( _t == Sustransition ) return "Sustransition";
    if ( _t == Dtrans ) return "Dtrans";
    return super.getNameOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf( TransitionRate _t ) { 
    if ( _t == Sustransition ) return covid19Unemployment;
    if ( _t == Dtrans ) return covid19Unemployment;
    return super.getStatechartOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testGuardOf( TransitionRate _t ) {
    if ( _t == Sustransition ) return 
 
;
    if ( _t == Dtrans ) return 
 
;
    return super.testGuardOf(  _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( TransitionRate self ) {
    if ( self == Sustransition ) {
      exitState( Exposed, self, true );
      {
 
;}
          enterState( Infected, true );
      return;
    }
    if ( self == Dtrans ) {
      exitState( Infected, self, true );
      {
 
;}
          enterState( Dead, true );
      return;
    }
    super.executeActionOf( self );
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateRateOf( TransitionRate _t ) {
    double _value;
    if ( _t == Sustransition ) {
      _value = 
main.infectionByAge(age);
//0.2
//main.infectionByRace(ethnicity);
//0.6 
;
      _value = toModelRate( _value, PER_WEEK );
      return _value;
    }
    if ( _t == Dtrans ) {
      _value = 
//main.infectionByAge(age);
//0.05 //perweek
main.infectionByRace(ethnicity); 
;
      _value = toModelRate( _value, PER_WEEK );
      return _value;
    }
    return super.evaluateRateOf( _t );
  }


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
  protected static final int _roundRectangle = 1;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 2;

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
	  level.addAll(roundRectangle);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _roundRectangle:
        if (true) {
          ShapeRoundedRectangle self = this.roundRectangle;
          
 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  // Stub function for code completion support (internal)
  @AnyLogicInternalCodegenAPI
  private void _stubForReplication_xjal() {
    {
      int _result_xjal = 
 
;
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _roundRectangle_SetDynamicParams_xjal( ShapeRoundedRectangle shape ) {
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
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRadius(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
color 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeRoundedRectangle roundRectangle;
  protected com.anylogic.engine.markup.Level level;

  private com.anylogic.engine.markup.Level[] _getLevels_xjal;

  @Override
  public com.anylogic.engine.markup.Level[] getLevels() {
    return _getLevels_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    roundRectangle = new ShapeRoundedRectangle(
		true,0.0, -20.0, 0.0, 
        peru, white,
		20.0, 20.0,10.0,  
		1.0, LINE_STYLE_SOLID	 ) {
      @Override
      public void updateDynamicProperties() {
        _roundRectangle_SetDynamicParams_xjal( this );
        super.updateDynamicProperties();
      }
    };

  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
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
  public Person( Engine engine, Agent owner, AgentList<? extends Person> ownerPopulation ) {
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
    main = get_Main();
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Person() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Person( int age, Ethnicity ethnicity ) {
    markParametersAreSet();
    this.age = age;
    this.ethnicity = ethnicity;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_Person_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
	_initialize_level_xjal();
    level.initialize();
    presentation = new ShapeTopLevelPresentationGroup( Person.this, true, 0, 0, 0, 0 , level );
    icon = new ShapeModelElementsGroup( Person.this, getElementProperty( "coved19simulation.Person.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( Person.class );
    // Dynamic initialization of persistent elements
    _createPersistentElementsBS0_xjal();
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
    covid19Unemployment.start();
  }
 
  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();
    
 
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Person_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Person_xjal() {
    color = 
 
;
  }

  // User API -----------------------------------------------------
  public Main get_Main() {
    {
      Agent owner = getOwner();
      if ( owner instanceof Main ) return (Main) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient coved19simulation.Main main;

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
    
 
    covid19Unemployment.fireEvent( _msg_xjal );
  }



  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public AgentList<? extends Person> getPopulation() {
    return (AgentList<? extends Person>) super.getPopulation();
  }

  public List<? extends Person> agentsInRange( double distance ) {
    return (List<? extends Person>) super.agentsInRange( distance );
  }

  // Reaction on changes -------------------------------------
  public void onChange() {
    super.onChange();
    covid19Unemployment.onChange();
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    covid19Unemployment.onDestroy();
    // On destroy code
    
 
    super.onDestroy();
  }

  // Additional class code

 
  // End of additional class code


}
