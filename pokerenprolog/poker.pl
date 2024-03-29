% Aplicacion para jugar al poker en prolog
%
%Design by:
%    - Ram�n Costafreda
%    - Marta Gonzalez
%    - Jose Martin
%    - Sergio Gonzalez
%
%Universidad San Pablo Ceu (Madrid)
%
%
%


:- use_module(library(pce)).




rank([ace,10,9,8,7,6,5,4,3,2]).

suit([spades,hearts,diamonds,clubs]).

card(R,S) :- rank(R1), suit(S1), member(R,R1),member(S,S1).

%%  CREAMOS LA BARAJA USANDO EL PRODUCTO CARTESIANO




baraja:- 
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



%%      COGER CARTA DE LA BARAJA Y BORRARLA DE ELLA

cogerCartaAleatoria(Carta):-
        inicial_baraja(R),
        length(R,Longitud),
        %writeln(Longitud),
        random(0,Longitud,Carta1),
        nth0(Carta1,R,Carta),
        select(Carta,R,RestoBaraja),
        retractall(inicial_baraja(_)),
        assert(inicial_baraja(RestoBaraja)).
        %length(RestoBaraja,Popo),

        %writeln('longitud final'),
        %writeln(Popo).



%%      RESULTADO DE JUGADOR
       


%%      DARLE DOS CARTAS A CADA JUGADOR



jugadorCarta(Jugador,[Carta1,Carta2]):-
        retractall(carta_jugador(Jugador,[Carta1,Carta2])),
        assert(carta_jugador(Jugador,[Carta1,Carta2])).
%%      COLOCAMOS 5 CARTAS EN LA MESA



mesa :- retractall(cartasMesa(_)),
        writeln('********** MESA DE LA PARTIDA ***************'),
        cogerCartaAleatoria(Carta1),
        writeln(Carta1),
        cogerCartaAleatoria(Carta2),
        writeln(Carta2),
        cogerCartaAleatoria(Carta3),
        writeln(Carta3),
        cogerCartaAleatoria(Carta4),
        writeln(Carta4),
        cogerCartaAleatoria(Carta5),
        writeln(Carta5),
        writeln('*********************************************'),
        assert(cartasMesa([Carta1,Carta2,Carta3,Carta4,Carta5])).
  
   
%%      TOTAL DE CARTAS POR JUGADOR


totalCartasJugadores([],[]).
totalCartasJugadores([Jugador|RestoJugadores],[jugadorCarta(Jugador,[Carta1,Carta2|CartasMesa])|RestoJugadoresCartas]):-
                writeln('********** Cartas de jugadores ***************'),
                write('Jugador: '),
                writeln(Jugador),
                writeln('Cartas: '),
                cogerCartaAleatoria(Carta1),
                cogerCartaAleatoria(Carta2),
                writeln(Carta1),
                writeln(Carta2),
                writeln('**********************************************'),
                
                 cartasMesa(CartasMesa),
                 totalCartasJugadores(RestoJugadores,RestoJugadoresCartas).
        
 
jugarPartida(ListaJugadores):-
        baraja,
        retractall(listaJugadores(_)),
        assert(listaJugadores(ListaJugadores)),
        mesa,
        totalCartasJugadores(ListaJugadores,JugadoresCartas),
        %writeln(JugadoresCartas),
        retractall(puntosJugador(_,_,_)),
        winning_hand(JugadoresCartas),
       % compilar(Pokemon),
	%write(Pokemon),
        obtenerGanador(_).     
%%      


all_dif([]).
all_dif([D|Ds]) :-
        dif_from(Ds, D),
        all_dif(Ds).

dif_from([], _).
dif_from([A|As], D) :-
        dif(A, D),
        dif_from(As, D).

%has_pair(card(R,S),[card(R,S1)],[card(R,S),card(R,S1)],[]) :-
%        S\=S1,
%        writeln('caso2'),!.
%has_pair(card(R,S),[card(R1,S1)],[],[card(R,S),card(R1,S1)]) :-
%        writeln('caso 1'),!.
% has_pair(card(R,S),[card(R,S1)|RestHand],[card(R,S),card(R,S1)],RestHand) :-
%         S\=S1, writeln('caso3'),!.
%        
% has_pair(card(R,S),[card(R1,S1)|RestHand],Pair,[card(R1,S1)|RestHand1]) :-
%         R\=R1, writeln('caso recursivo'), writeln(RestHand),
% writeln([card(R1,S1)|RestHand1]),
% has_pair(card(R,S),RestHand,Pair,RestHand1).




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



tie_break(Hand1, Hand2, Community) :-
        three_of_a_kind([Hand1|Community]), three_of_a_kind([Hand2|Community]).

highest_card(Hc) :-
        not(three_of_a_kind(Hc)),
        not(one_pair(Hc)).



one_pair(OP, [card(R,S1),card(R,S2)],R) :-
        all_dif([S1,S2]),
        member(card(R,S1), OP),
        member(card(R,S2), OP),!.

best_pair([card(R1,_S1)|_RestPair1], [card(R2,_S2)|_Pair2], Result) :-
        value(R1,V1),
        value(R2,V2),
        ( ( V1 > V2, Result = 1,writeln('Jugador 1 gana a puntos'),!);
        ( V1 = V2, Result = 2,writeln('Empate a puntos'),!);
        ( V1 < V2, Result = 3,writeln('Jugador 2 gana a puntos'),!) ).

three_of_a_kind(TOAK,[card(R,S1),card(R,S2),card(R,S3)]) :-
        all_dif([S1,S2,S3]),
        member(card(R,S1), TOAK),
        member(card(R,S2), TOAK),
        member(card(R,S3), TOAK),!.

winning_hand([]).
winning_hand([jugadorCarta(Jugador,Hand)|RestoJugadoresCartas]):-
        evaluar_mano(Jugador,Hand),
        winning_hand(RestoJugadoresCartas).

evaluarGanador(L, G) :- 
evaluarGanador(L, gProvisional(jProv, -1,_), G).

evaluarGanador([],gProvisional(Jugador,Resultado,Text), ganador(Jugador,Resultado,Text)):-
        writeln(' '),
        writeln(' '),
        writeln(' '),

        writeln('********** Ganador de la partida ***************'),
                write(Jugador),
                write(' gana la partida con '),
                writeln(Text),
        writeln('************************************************').

evaluarGanador([puntuacion(_Jugador, Puntuacion,_) | R], gProvisional(JProvisional, PProvisional,TextProv), G) :-
        Puntuacion =< PProvisional,
        evaluarGanador(R, gProvisional(JProvisional, PProvisional,TextProv), G), !.


evaluarGanador([puntuacion(Jugador, Puntuacion, Text) | R], gProvisional(_JProvisional, PProvisional,_), G) :-
        Puntuacion > PProvisional,
        evaluarGanador(R, gProvisional(Jugador, Puntuacion,Text), G), !.
        

obtenerGanador(Ganador):-
        findall( puntuacion(J, P , V), puntosJugador(J, P, V), Lista),
        %writeln(Lista),
        evaluarGanador(Lista, Ganador).


evaluar_mano(Jugador, Hand1) :-


        
             (   three_of_a_kind(Hand1,_),write(Jugador),writeln(' tiene trio'),highestHand(threeofakind, Value),
                                 assert(puntosJugador(Jugador,Value,'trio')),!);
       
        
         (   one_pair(Hand1,_,R),highestHand(pair,R ,Value),write(Jugador),writeln(' tiene pareja'),assert(puntosJugador(Jugador,Value,'pareja')),!);
        
          ( highestHand(Hand1, Value), assert(puntosJugador(Jugador,Value,'carta alta')),write(Jugador),writeln(' tiene carta alta'),!).
        
        





% Mano : Valor

highestHand(card(1,_S),1).
highestHand(card(2,_S),2).
highestHand(card(3,_S),3).
highestHand(card(4,_S),4).
highestHand(card(5,_S),5).
highestHand(card(6,_S),6).
highestHand(card(7,_S),7).
highestHand(card(8,_S),8).
highestHand(card(9,_S),9).
highestHand(card(10,_S),10).
highestHand(card(jack,_S),11).
highestHand(card(queen,_S),12).
highestHand(card(king,_S),13).
highestHand(card(ace,_S),14).



highestHand(pair,2,22).
highestHand(pair,3,23).
highestHand(pair,4,24).
highestHand(pair,5,25).
highestHand(pair,6,26).
highestHand(pair,7,27).
highestHand(pair,8,28).
highestHand(pair,9,29).
highestHand(pair,10,30).
highestHand(pair,jack,31).
highestHand(pair,queen,32).
highestHand(pair,king,33).
highestHand(pair,ace,34).
highestHand(threeofakind,50).









highestHand([card(R1,S1)], Resultado) :-
        highestHand(card(R1,S1),Value1),
        Resultado is Value1,!.
                
highestHand([card(R1,S1)|RestHand],Resultado) :-
        highestHand(card(R1,S1),Value1),
        highestHand(RestHand,Resultado1),
        (   (   Resultado1 < Value1, 
        Resultado is Value1);
        (   Resultado1 >= Value1, Resultado is Resultado1)).















        
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

save(Exe) :-
        pce_autoload_all,
        pce_autoload_all,
        qsave_program(Exe,
                      [ emulator(swi('bin/xpce-stub.exe')),
                        stand_alone(true),
                        goal(main)
                      ]).



compilar(P):-
  qsave_program(P,[
    local(0),
    global(0),
    trail(0),
    argument(0),
    goal(pce_main_loop(main)),
    class(kernel),
    autoload(true),
    op(save),
    stand_alone(true),
    emulator('bin/xpce-stub.exe')
  ]).









