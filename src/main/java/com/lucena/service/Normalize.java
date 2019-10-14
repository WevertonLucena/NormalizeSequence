package com.lucena.service;

import org.springframework.stereotype.Service;

@Service
public class Normalize {
	
	public int  normalizeSequence(String sequence, int counter, int number)
    {

        char[] seqChar = sequence.toCharArray();

        if (counter % 2 == 0)
        {
        	
            if (seqChar[counter] == '}')
                number++;
        }
        else
        {
            if (seqChar[counter] == '{')
                number++;
        }

        if (counter < sequence.length() - 1)
        	return normalizeSequence(sequence, counter + 1, number);
        else
           return number;

    }

}
