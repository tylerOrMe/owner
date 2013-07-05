---
layout: docs
title: Frequently Asked Questions
prev_section: configuring
next_section: support
permalink: /docs/faq/
---

## What does "OWNER" name mean?

Since this API is used to access *Properties* files, and we implement mapping interfaces to deal with those,
somehow interfaces are *owners* for the properties. So here comes the name OWNER, all uppercase because when you speak
about it you must shout it out :-)

The true story, is that I tried to find a decent name for the project, but I didn't come out with anything better.
Sorry.

## Is OWNER a stable API?

The codebase is very compact, and I try to keep the test coverage to 100%, developing many tests for each new feature.
You have the source, you can help improving the library and fix the bugs if you find some.

Still, OWNER API is a very early project, and APIs may change in the future to add/change some behaviors. But the
philosophy is to keep always backward compatibility (unless not possible).

## What happens if some `key` is not bound to a default value, and the properties file has no value for that key?

The returned value is `null`. This is consistent with the behavior of the [Properties][properties] class.  
If you think that this should be changed, please submit a [change request][issues] explaining your idea.  
A possible solution can be inventing a new annotation like `@Mandatory` on class level and/or method level for those
methods that do not specify a `@DefaultValue`, so that if the user forgets to specify a value for the mandatory
property, a (subclass of) RuntimeException is thrown when the Config class is instantiated, to point out the
misconfiguration.

## Why OWNER API doesn't implement this ${pretty.neat.feature} ?

Explain it on [github issues][issues]. If I like the idea I will implement it.  
Or, you can implement by yourself and send me a push request on GitHub.  
See also [Contributing]({{ site.url }}/docs/contributing/).

The idea is to keep things minimal and code clean and easy. And for every new feature, having a complete test suite to
verify all cases.

  [properties]: http://docs.oracle.com/javase/7/docs/api/java/util/Properties.html
  [issues]: https://github.com/lviggiano/owner/issues

## Who is using OWNER?

I have no idea. I implemented OWNER for a web application I was working on, then I decided to share it. And it looks 
like [somebody][#32] is now using it. Including my friend [Bruno] who is a great guy and makes me proud of it.  
If you feel like, drop a comment [here][#32].

The fact I am receiving feedback, request for features and changes, mails and questions, makes me think that this 
library is useful to some people around the world, and this encourages me to work and improve it.  
So, don't be shy to introduce yourself.

  [#32]: https://github.com/lviggiano/owner/issues/32
  [Bruno]: https://github.com/lviggiano/owner/issues/32#issuecomment-19466459