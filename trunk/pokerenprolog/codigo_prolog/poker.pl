% hand(Hs) :- length(Hs, 5),
%	cards(Hs).

% cards([]).
% cards([card(Rank,Suit)|Cs]) :-
%	rank(Rank),
%	suit(Suit),
%	cards(Cs).


rank([ace,10,9,8,7,6,5,4,3,2]).

suit([spades,hearts,diamonds,clubs]).

card(R,S) :- rank(R), suit(S).

%%  CREAMOS LA BARAJA USANDO EL PRODUCTO CARTESIANO




baraja(R):- 
	rank(M),
	suit(N),
	findall(card(X,Y), parejas(M,N,(X,Y)),R),
	retractall(inicial_baraja(_)),
	assert(inicial_baraja(R)).
	

parejas(M, N, (X, Y)):-
    miembros(X, M),
    miembros(Y, N).

miembros(X, [X|_]).
miembros(X, [_|R]):- member(X, R).



%%	COGER CARTA DE LA BARAJA Y BORRARLA DE ELLA

cogerCartaAleatoria(Carta):-
	inicial_baraja(R),
	length(R,Longitud),
	%writeln(Longitud),
	random(0,Longitud,Carta1),
        nth0(Carta1,R,Carta),
	select(Carta,R,RestoBaraja),
	retractall(inicial_baraja(_)),
	assert(inicial_baraja(RestoBaraja)),
	length(RestoBaraja,Popo),

	writeln('longitud final'),
	writeln(Popo).



%%	RESULTADO DE JUGADOR
       


%%	DARLE DOS CARTAS A CADA JUGADOR



jugadorCarta(Jugador,[Carta1,Carta2]):-
	retractall(carta_jugador(Jugador,[Carta1,Carta2])),
	assert(carta_jugador(Jugador,[Carta1,Carta2])).
%%	COLOCAMOS 5 CARTAS EN LA MESA



mesa(Carta1, Carta2, Carta3, Carta4, Carta5) :-
	
	retractall(cartasMesa(_)),
      	cogerCartaAleatoria(Carta1),
	cogerCartaAleatoria(Carta2),
	cogerCartaAleatoria(Carta3),
	cogerCartaAleatoria(Carta4),
	cogerCartaAleatoria(Carta5),
        assert(cartasMesa([Carta1,Carta2,Carta3,Carta4,Carta5])).
  
   
%%	TOTAL DE CARTAS POR JUGADOR


totalCartasJugadores([],[]).
totalCartasJugadores([Jugador|RestoJugadores],[jugadorCarta(Jugador,[Carta1,Carta2|CartasMesa])|RestoJugadoresCartas]):-
	
		 cogerCartaAleatoria(Carta1),
		 cogerCartaAleatoria(Carta2),
		 cartasMesa(CartasMesa),
		 totalCartasJugadores(RestoJugadores,RestoJugadoresCartas).
	
	         %writeln('Introduzca su nombre'),
		 %read(S),
		 %write('El nombre es:'),
		 %writeln(S), 
	         %inicializarCartaJugador(L1),
	         %cartasMesa(L2),
                 %append(L1,L2,LTotal).




%%	CREACION DE UNA PARTIDA


jugarPartida(R ,ListaJugadores,Cartas1,Cartas2,Cartas3,Cartas4,Cartas5):-
	baraja(R),
	retractall( listaJugadores(_)),
       	assert(listaJugadores(ListaJugadores)),
	mesa(Cartas1,Cartas2,Cartas3,Cartas4,Cartas5),
	totalCartasJugadores(ListaJugadores,JugadoresCartas),
	
	
	writeln(JugadoresCartas),
	winning_hand(JugadoresCartas).


%%	


all_dif([]).
all_dif([D|Ds]) :-
	dif_from(Ds, D),
	all_dif(Ds).

dif_from([], _).
dif_from([A|As], D) :-
	dif(A, D),
	dif_from(As, D).

has_pair(card(R,S),[card(R,S1)],[card(R,S),card(R,S1)],[]) :-
	S\=S1,
	writeln('caso2'),!.
has_pair(card(R,S),[card(R1,S1)],[],[card(R,S),card(R1,S1)]) :-
	writeln('caso 1'),!.
has_pair(card(R,S),[card(R,S1)|RestHand],[card(R,S),card(R,S1)],RestHand) :-
	S\=S1,
	writeln('caso3'),!.
	
has_pair(card(R,S),[card(R1,S1)|RestHand],Pair,[card(R1,S1)|RestHand1]) :-
	R\=R1,
	writeln('caso recursivo'),
	writeln(RestHand),
	writeln([card(R1,S1)|RestHand1]),
	has_pair(card(R,S),RestHand,Pair,RestHand1).

select_from([card(R,S)], Cards, [card(R,S)]) :-
	writeln('caso 1'),
	\+ member(card(R,S), Cards),!.

select_from([card(R,S)], Cards, []) :-
	writeln('caso 2'),
	member(card(R,S), Cards),!.

select_from([card(R,S)|Hand], Cards, [card(R,S)|RestHand]) :-
	writeln('caso 3'),
	\+ member(card(R,S), Cards),
	select_from(Hand, Cards, RestHand).

select_from([card(R,S)|Hand], Cards, RestHand) :-
	writeln('caso 4'),
	member(card(R,S), Cards),
	select_from(Hand, Cards, RestHand).

select_pair(Hand, [card(R,S1),card(R,S2)]) :-
	all_dif([S1,S2]),
	member(card(R,S1), Hand),
	member(card(R,S2), Hand),!.



tie_break(Hand1, Hand2, Community) :-
	three_of_a_kind([Hand1|Community]), three_of_a_kind([Hand2|Community]).

highest_card(Hc) :-
	not(three_of_a_kind(Hc)),
	not(one_pair(Hc)).

one_pair(OP, [card(R,S1),card(R,S2)]) :-
	all_dif([S1,S2]),
	member(card(R,S1), OP),
	member(card(R,S2), OP),!.

best_pair([card(R1,_S1)|_RestPair1], [card(R2,_S2)|_Pair2], Result) :-
	value(R1,V1),
	value(R2,V2),
	( ( V1 > V2, Result = 1,writeln('Jugador 1 gana a puntos'),!);
	( V1 = V2, Result = 2,writeln('Empate a puntos'),!);
	( V1 < V2, Result = 3,writeln('Jugador 2 gana a puntos'),!) ).

three_of_a_kind(TOAK) :-
	all_dif([S1,S2,S3]),
	member(card(R,S1), TOAK),
	member(card(R,S2), TOAK),
	member(card(R,S3), TOAK),!.




winning_hand([]).
winning_hand([jugadorCarta(Jugador,Hand)|RestoJugadoresCartas]):-
       writeln('hi!'),
	
	evaluar_mano(Jugador,Hand),
	
	winning_hand(RestoJugadoresCartas).




evaluar_mano(Jugador, Hand1) :-
	
	
	     (	 three_of_a_kind(Hand1),
		 write('Jugador: '),
		 write(Jugador),
		 writeln(' tiene trio'),!);
       
	
	 (   one_pair(Hand1,_),write('Jugador: '),write(Jugador),writeln(' tiene pareja'));
	
	   write(Jugador),writeln(' no tiene nada').
	
	
	
	
%%check_hand(_Mano) :-
	%winning_hand([card(ace,spades),card(ace,hearts)],[card(9,hearts),card(9,diamonds)],[card(ace,diamonds)],Result1),
	%writeln(Result1),
	%winning_hand([card(ace,spades),card(ace,hearts)],[card(9,hearts),card(9,diamonds)],[card(9,clubs)],Result2),
	%writeln(Result2),
	%winning_hand([card(ace,spades),card(2,hearts)],[card(3,hearts),card(9,diamonds)],[card(3,diamonds)],Result3),
	%writeln(Result3),
	%winning_hand([card(ace,spades),card(ace,hearts)],[card(9,hearts),card(9,diamonds)],[card(ace,diamonds),card(9,clubs)],Result4),
	%writeln(Result4).	
	
	
	
	
	

value(ace,14).
value(king,13).
value(queen,12).
value(jack,11).
value(10,10).
value(9,9).
value(8,8).
value(7,7).
value(6,6).
value(5,5).
value(4,4).
value(3,3).
value(2,2).





















































