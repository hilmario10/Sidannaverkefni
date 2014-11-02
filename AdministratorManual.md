Administrator Manual:


This manual is for windows users.

- Install Git Shell
		In your browser navigate to https://github.com/hilmario10/Sidannaverkefni
	 	and fork that repository.
		Open git Shell and navigate to a preferred folder to clone the project to your local machine.

- If you already have ssh key installed then run the command
		git clone git@github.com:hilmario10/Sidannaverkefni.git   
- If you do not have an ssh key installed then run the command
		git clone https://github.com/hilmario10/Sidannaverkefni.git

- Install gradle.



- Setup Travis:
		Install Ruby
		Version 1.9.3

- Install Travis
		By running this command 
		gem install travis


- Navigate to https://travis-ci.org and create a account.

- Connect your Travis to GitHub.
		By going into settings in your github you can confirm that a connection between travis and git has been made. This is done by going to Service Hooks and find Travis. If you see a hook symbol next to travis then there is a connection.

- Setup Heroku:

- Navigate to http://heroku.com and create a account.

- Install heroku toolbelt 
		By going to https://toolbelt.heroku.com/windows

- Install the encrypted heroku key into your .travis.yml by running this command
		travis setup heroku

- To install a global env: key from heroku the following command needs to be performed:
		travis encrypt HEROKU_API_KEY=<your _heroku_key>  --add



