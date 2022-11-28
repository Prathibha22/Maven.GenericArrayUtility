package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] _arrayOfObjects;

    public ArrayUtility(T[] _arrayOfObjects) {
        this._arrayOfObjects = _arrayOfObjects;
    }

    public Integer getNumberOfOccurrences(Object valueToEvaluate) {
        Integer count=0;
        for(int i=0;i<this._arrayOfObjects.length;i++)
            if(this._arrayOfObjects[i].equals(valueToEvaluate)) count++;
        return count;
    }

    public T[] removeValue(Object valueToRemove) {
        ArrayList<T> alObj=new ArrayList<>();
        for(int i=0;i<this._arrayOfObjects.length;i++) {
            if (!(_arrayOfObjects[i].equals(valueToRemove)))
                alObj.add((T)_arrayOfObjects[i]);
        }
        return toArray(alObj);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T mostCommonObject=null;
        int count=0;
        int mostCommonCount=0;
        T[] mergedArray=Arrays.copyOf(this._arrayOfObjects,this._arrayOfObjects.length+arrayToMerge.length);
        System.arraycopy(arrayToMerge,0,mergedArray,this._arrayOfObjects.length,arrayToMerge.length);
        for(T ele:mergedArray){
            for(T eleCompare:mergedArray)
                if(ele.equals(eleCompare)) count++;
            if(count>mostCommonCount){
                mostCommonCount=count;
                mostCommonObject=ele;
            }
            count=0;
        }
        return mostCommonObject;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, Object valueToEvaluate) {
        Integer count=0;
        T[] mergedArray=Arrays.copyOf(this._arrayOfObjects,this._arrayOfObjects.length+arrayToMerge.length);
        System.arraycopy(arrayToMerge,0,mergedArray,this._arrayOfObjects.length,arrayToMerge.length);
        for(T ele:mergedArray)
            if(ele.equals(valueToEvaluate)) count++;
        return count;
    }
    public T[] toArray(List<T> list) {
        T[] output = (T[]) Array.newInstance(list.get(0).getClass(), list.size());
        for (int i=0; i < list.size(); i++) {
            output[i] = list.get(i);
        }
        return output;
    }
}
