% hand(Hs) :- length(Hs, 5),
%	cards(Hs).

% cards([]).
% cards([card(Rank,Suit)|Cs]) :-
%	rank(Rank),
%	suit(Suit),
%	cards(Cs).


rank(R) :- member(R, [ace,10,9,8,7,6,5,4,3,2]).

suit(S) :- member(S,[spades,hearts,diamonds,clubs]).

card(R,S) :- rank(R), suit(S).

baraja(Y) :- member(card(_,_),Y).

all_dif([]).
all_dif([D|Ds]) :-
	dif_from(Ds, D),
	all_dif(Ds).

dif_from([], _).
dif_from([A|As], D) :-
	dif(A, D),
	dif_from(As, D).

% Selecciono las tres cartas que forman mi trio
select_threeofakind(Hand, RestHand, ThreeOfAKind) :- 
	all_dif([S1,S2,S3]),
	member(card(R,S1), Hand),
	member(card(R,S2), Hand),
	member(card(R,S3), Hand),
	append(ThreeOfAKind,[card(R,S1)],ThreeOfAKind),
	append(ThreeOfAKind,[card(R,S2)],ThreeOfAKind),
	append(ThreeOfAKind,[card(R,S3)],ThreeOfAKind),
	delete(Hand,card(R,S1),Hand),
	delete(Hand,card(R,S2),Hand),
	delete(Hand,card(R,S3),Hand).

tie_break(Hand1, Hand2, Community) :-
	three_of_a_kind([Hand1|Community]), three_of_a_kind([Hand2|Community]).

highest_card(Hc) :-
	not(three_of_a_kind(Hc)),
	not(one_pair(Hc)).

one_pair(OP) :-
	all_dif([S1,S2]),
	member(card(R,S1), OP),
	member(card(R,S2), OP),!.

three_of_a_kind(TOAK) :-
	all_dif([S1,S2,S3]),
	member(card(R,S1), TOAK),
	member(card(R,S2), TOAK),
	member(card(R,S3), TOAK),!.

winning_hand(Hand1, Hand2, Community) :-
	three_of_a_kind([Hand1|Community]), not( three_of_a_kind([Hand1|Community])), !,
	one_pair([Hand1|Community]), not( one_pair([Hand1|Community])), !,
	tie_break(Hand1, Hand2, Community).


% two_pairs(TP) :-
%	all_dif([S1,S2]),
%	all_dif([S3,S4]),
%	member(card(R1,S1), TP),
%	member(card(R1,S2), TP),!,
%	member(card(R2,S3), TP),
%	member(card(R2,S4), TP),!.

