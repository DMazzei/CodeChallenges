# String Overlaping.

## Background

	Imagine you have 5 copies of the same page of text. You value this text and have no hard or soft copies of it. 
	Your two year old nephew visits and, while you are not looking, rips each page up into fragments and gleefully 
	plays in the “snow” he has just created.
	You need at least one copy of that page of text back ASAP. As punishment to your niece, who should have 
	been supervising your nephew at the time of the incident, you set her the painstaking task of keying in all the 
	paper text fragments to a text file on your shiny MacBook Pro. Now the task is yours. 
	Can you reassemble a soft copy of the original document?

## Challenge

	Write a program to reassemble a given set of text fragments into their original sequence. For this challenge 
	your program should have a main method accepting one argument – the path to a well-formed UTF-8 encoded 
	text file. Each line in the file represents a test case of the main functionality of your program: read it, process 
	it and println to the console the corresponding defragmented output.
	Each line contains text fragments separated by a semicolon, ‘;’. 
	You can assume that every fragment has length at least 2.

	Example input 1:
		O draconia;conian devil! Oh la;h lame sa;saint!

	Example output 1:
		O draconian devil! Oh lame saint!

## Implementation

	For each input line, search the collection of fragments to locate the pair with the maximal overlap match then 
	merge those two fragments. 
	This operation will decrease the total number of fragments by one. Repeat until there is only one fragment 
	remaining in the collection. 
	This is the defragmented line / reassembled document. If there is more than one pair of maximally overlapping 
	fragments in any iteration then just merge one of them. So long as you merge one maximally overlapping 
	pair per iteration the test inputs are guaranteed to result in good and deterministic output.
	When comparing for overlaps, compare case sensitively.

	Examples:

	- "ABCDEF" and "DEFG" overlap with overlap length 3
	- "ABCDEF" and "XYZABC" overlap with overlap length 3
	- "ABCDEF" and "BCDE" overlap with overlap length 4
	- "ABCDEF" and "XCDEZ" do *not* overlap (they have matching characters in the middle, but the overlap 
	does not extend to the end of either string).

