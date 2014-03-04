package br.cin.ufpe.nesc2cpn.repository;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author avld
 */
public class Line {
    private long id;

    // ------------------------------- //

    private boolean radioStart;
    private boolean radioStop;
    private boolean radioSend;

    private boolean led0Start;
    private boolean led0Stop;
    private boolean led0Toggle;

    private boolean led1Start;
    private boolean led1Stop;
    private boolean led1Toggle;

    private boolean led2Start;
    private boolean led2Stop;
    private boolean led2Toggle;

    // ------------------------------- //

    private boolean radioOn;
    private boolean led0On;
    private boolean led1On;
    private boolean led2On;

    // ------------------------------- //

    private String moduleName;
    private String interfaceName;
    private String methodName;
    private String eventName;

    private double energyMean;
    private double energyVariance;
    private double energyError;

    private double powerMean;
    private double powerVariance;
    private double powerError;

    private double timeMean;
    private double timeVariance;
    private double timeError;

    private String petriNet;

    //Isto é usado na modelagem
    private String interfaceNick;

    // ------------------------------- //

    private Set<Long> eventSet;

    public Line()
    {
        radioOn = true;
        led0On = true;
        led1On = true;
        led2On = true;
        radioSend = false;

        eventSet = new HashSet<Long>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getEnergyMean() {
        return energyMean;
    }

    public void setEnergyMean(double energyMean) {
        this.energyMean = energyMean;
    }

    public double getEnergyVariance() {
        return energyVariance;
    }

    public void setEnergyVariance(double energyVariance) {
        this.energyVariance = energyVariance;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getInterfaceName() {
        return interfaceName  == null ? "" : interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName  == null ? "" : methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getModuleName()
    {
        return moduleName == null ? "" : moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public double getPowerMean() {
        return powerMean;
    }

    public void setPowerMean(double powerMean) {
        this.powerMean = powerMean;
    }

    public double getPowerVariance() {
        return powerVariance;
    }

    public void setPowerVariance(double powerVariance) {
        this.powerVariance = powerVariance;
    }

    public double getTimeMean() {
        return timeMean;
    }

    public void setTimeMean(double timeMean) {
        this.timeMean = timeMean;
    }

    public double getTimeVariance() {
        return timeVariance;
    }

    public void setTimeVariance(double timeVariance) {
        this.timeVariance = timeVariance;
    }

    public String getPetriNet() {
        return petriNet;
    }

    public void setPetriNet(String petriNet) {
        this.petriNet = petriNet;
    }

    public boolean isLed0On() {
        return led0On;
    }

    public void setLed0On(boolean led0On) {
        this.led0On = led0On;
    }

    public boolean isLed1On() {
        return led1On;
    }

    public void setLed1On(boolean led1On) {
        this.led1On = led1On;
    }

    public boolean isLed2On() {
        return led2On;
    }

    public void setLed2On(boolean led2On) {
        this.led2On = led2On;
    }

    public boolean isRadioOn() {
        return radioOn;
    }

    public void setRadioOn(boolean radioOn) {
        this.radioOn = radioOn;
    }

    public boolean isLed0Start() {
        return led0Start;
    }

    public void setLed0Start(boolean led0Start) {
        this.led0Start = led0Start;
    }

    public boolean isLed0Stop() {
        return led0Stop;
    }

    public void setLed0Stop(boolean led0Stop) {
        this.led0Stop = led0Stop;
    }

    public boolean isLed0Toggle() {
        return led0Toggle;
    }

    public void setLed0Toggle(boolean led0Toggle) {
        this.led0Toggle = led0Toggle;
    }

    public boolean isLed1Start() {
        return led1Start;
    }

    public void setLed1Start(boolean led1Start) {
        this.led1Start = led1Start;
    }

    public boolean isLed1Stop() {
        return led1Stop;
    }

    public void setLed1Stop(boolean led1Stop) {
        this.led1Stop = led1Stop;
    }

    public boolean isLed1Toggle() {
        return led1Toggle;
    }

    public void setLed1Toggle(boolean led1Toggle) {
        this.led1Toggle = led1Toggle;
    }

    public boolean isLed2Start() {
        return led2Start;
    }

    public void setLed2Start(boolean led2Start) {
        this.led2Start = led2Start;
    }

    public boolean isLed2Stop() {
        return led2Stop;
    }

    public void setLed2Stop(boolean led2Stop) {
        this.led2Stop = led2Stop;
    }

    public boolean isLed2Toggle() {
        return led2Toggle;
    }

    public void setLed2Toggle(boolean led2Toggle) {
        this.led2Toggle = led2Toggle;
    }

    public boolean isRadioStart() {
        return radioStart;
    }

    public void setRadioStart(boolean radioStart) {
        this.radioStart = radioStart;
    }

    public boolean isRadioStop() {
        return radioStop;
    }

    public void setRadioStop(boolean radioStop) {
        this.radioStop = radioStop;
    }

    public Set<Long> getEventSet() {
        return eventSet;
    }

    public void setEventSet(Set<Long> eventSet)
    {
        this.eventSet = eventSet;
    }

    public String getInterfaceNick() {
        return interfaceNick;
    }

    public void setInterfaceNick(String interfaceNick) {
        this.interfaceNick = interfaceNick;
    }

    public double getEnergyError() {
        return energyError;
    }

    public void setEnergyError(double energyError) {
        this.energyError = energyError;
    }

    public double getPowerError() {
        return powerError;
    }

    public void setPowerError(double powerError) {
        this.powerError = powerError;
    }

    public double getTimeError() {
        return timeError;
    }

    public void setTimeError(double timeError) {
        this.timeError = timeError;
    }

    public boolean isRadioSend() {
        return radioSend;
    }

    public void setRadioSend(boolean radioSend) {
        this.radioSend = radioSend;
    }
    
}
