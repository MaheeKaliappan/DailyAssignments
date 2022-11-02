package com.zoho.javaprograms;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InterviewPanel {

	Deque<String> interview = new ArrayDeque<String>();
	Queue<String> waitingCandidate = new LinkedList<String>();
	
	Scanner reader = new Scanner(System.in);
		
		
	public static void main(String[] args) {
		InterviewPanel interviewPanel  = new InterviewPanel();
		interviewPanel.addFuntionality();

	}
	
	private void addFuntionality() {
		while(true)
		{
			System.out.println("1.Add Member in Queue Press\n2.Push Candidate In Waiting Hall\n3.HR MeetUp");
			
			int choice = reader.nextInt();
			if(choice == 1)
			{
				System.out.println("Candidate Name");
				interview.add(reader.next());
				
				System.out.println(interview.toString());
				System.out.println(interview.size());
			}
			else if(choice == 2)
			{
				pushCandidateInWaitingHall();
			}
			else if(choice == 3)
			{
				if(waitingCandidate.size()!=0)
				{
					pushCandidateInHR(waitingCandidate.remove());
				}
				else
				{
					System.out.println("Interview Got Over");
				}
				
				
			}
			else
			{
				System.out.println("Invalid Input");
			}
		}
		
		
	}

	private void pushCandidateInHR(String candidateName) {
		System.out.println("One To One In Hr Candidate Name "+candidateName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void pushCandidateInWaitingHall() {
		if(interview.size()== 0)
		{
			System.out.println("No Candidates");
		}
		else
		{
			if(waitingCandidate.size()<5)
			{
				
					for(int index = waitingCandidate.size();index<5;index++)
					{
						if(!(interview.isEmpty()))
						{
							waitingCandidate.add(interview.remove());
						}
						
					}
			}
		}
		
//		if(waitingCandidate.size()<waitingCandidateCount)
//		{
//			if(interview.size()>=waitingCandidate.size())
//			{
//				for(int index = 0;index<waitingCandidateCount;index++)
//				{
//					waitingCandidate.add(interview.remove());
//				}
//			}
//			else if(interview.size()==0)
//			{
//				System.out.println("No Candidates");
//			}
//			else
//			{
//				for(int index = waitingCandidateCount;index<5;index++)
//				{
//					waitingCandidate.add(interview.remove());
//				}
//			}
//		}
//		else if(waitingCandidate.size()==5)
//		{
//			System.out.println("5 Candidates Here pleaase Wait");
//		}
		System.out.println(waitingCandidate.size()+" Person In Waiting Hall "+waitingCandidate.toString());
		
		
		//System.out.println(waitingCandidate.toString());
		
		
	}

}
